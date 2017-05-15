package com.dodo.hazelcast;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.dodo.model.Geocoding;
import com.dodo.model.Geocodings;

@Repository
public class HzRepository {

    private String messageUid;
    private String recipient;
    private String sender;
	private Geocodings geocodings;
	
	public String getMessageUid() {
		return messageUid;
	}


	public void setMessageUid(String messageUid) {
		this.messageUid = messageUid;
	}


	public String getRecipient() {
		return recipient;
	}


	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}


	public String getSender() {
		return sender;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}


	public Geocodings getGeocodings() {
		return geocodings;
	}


	public void setGeocodings(Geocodings geocodings) {
		this.geocodings = geocodings;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((geocodings == null) ? 0 : geocodings.hashCode());
		result = prime * result + ((messageUid == null) ? 0 : messageUid.hashCode());
		result = prime * result + ((recipient == null) ? 0 : recipient.hashCode());
		result = prime * result + ((sender == null) ? 0 : sender.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HzRepository other = (HzRepository) obj;
		if (geocodings == null) {
			if (other.geocodings != null)
				return false;
		} else if (!geocodings.equals(other.geocodings))
			return false;
		if (messageUid == null) {
			if (other.messageUid != null)
				return false;
		} else if (!messageUid.equals(other.messageUid))
			return false;
		if (recipient == null) {
			if (other.recipient != null)
				return false;
		} else if (!recipient.equals(other.recipient))
			return false;
		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "HzRepository [messageUid=" + messageUid + ", recipient=" + recipient + ", sender=" + sender
				+ ", geocodings=" + geocodings + "]";
	}


	//@Override
	@Cacheable("geocodings")
	public Geocodings fetAllGeocoding(){
		return geocodings;
	}

}
