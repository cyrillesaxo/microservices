package com.dodo.hazelcast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IQueue;

@Service
public class HazelcastService {

	private HazelcastInstance hzInstance;
	 
     public static final String ACCEPTED_MESSAGES_TRACKING_MAP_NAME = "received";
     public static final String RECIPIENT_QUEUE_NAME_SUFFIX = "recipient-";
 	 private static final Logger logger = LoggerFactory.getLogger(HazelcastService.class);

     @Autowired
     public HazelcastService(HazelcastInstance hzInstance) {
         this.hzInstance = hzInstance;
     }
 
     // Starting the HazelcastInstance is heavyweight, while retrieving a distributed object from it is not

     private IQueue<HzRepository> recipientQueue(String user) {
         return hzInstance.getQueue(RECIPIENT_QUEUE_NAME_SUFFIX + user);
     }


     private IMap<Object, Object> acceptedMessageUidMap() {
         return hzInstance.getMap(ACCEPTED_MESSAGES_TRACKING_MAP_NAME);
     }  
     
     public void send(HzRepository message)  {

         // Check if the message is duplicate. If duplicate, silently ignore it
         if( !isDuplicate(message)) {
        	 logger.debug("Submitting the message id:{}", message.getMessageUid());
             recipientQueue(message.getRecipient()).offer(message);

             // Save UID as accepted
             markAsAccepted(message);
         }

     } 
     
     
     public List<HzRepository> receive(String recipient) {
    	 logger.debug("Polling message for recipient: {}", recipient);

          // Poll recipient's queue until empty
         final List<HzRepository> messages = new ArrayList();
         while ( true ) {
             final HzRepository message = recipientQueue(recipient).poll();
             if ( message == null ) break;
             logger.debug("Polled message id:{}", message.getMessageUid());
             messages.add(message);
         }
         logger.debug("Returning {} messages", messages.size());

         // This is not a transactional receiver: If something happens here, the messages are lost...

         // Return the received messages
         return Collections.unmodifiableList(messages);
     }



     private boolean isDuplicate(HzRepository message) {
         // We just store and check the message UID. A distributed Set would suffice, but unfortunately
         // Hazelcast ISet doesn't support automatic eviction
         final boolean duplicate = acceptedMessageUidMap().containsKey(message.getMessageUid());
         logger.debug("Message id:{} is duplicate? {}", message.getMessageUid(), duplicate);
         return duplicate;
     }

     private void markAsAccepted(HzRepository message) {
    	 logger.debug("Marking message id:{} as accepted", message.getMessageUid());
         acceptedMessageUidMap().put(message.getMessageUid(),"");
     }
     
}
