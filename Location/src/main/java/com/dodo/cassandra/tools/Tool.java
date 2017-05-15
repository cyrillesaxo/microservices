package com.dodo.cassandra.tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.Properties;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dodo.cassandra.persistence.LocationPersistence;

public class Tool {
	private static final Logger logger = LoggerFactory.getLogger(LocationPersistence.class);
	
	public static Properties prop(){
		Properties prop = new Properties();
    	InputStream input = null;

    	try {
    		String propertyFile = "";
    		propertyFile = (System.getProperty("property.file")!=null)? System.getProperty("property.file"):"";
    		logger.info("propertyFile:"+propertyFile);
    		
    		//input = CassandraConnector.class.getClassLoader().getResourceAsStream(path+filename);
    		input = new FileInputStream(propertyFile);
    		prop.load(input);

    		return prop;
    		
    	} catch (IOException ex) {
    		ex.printStackTrace();
        } finally{
        	if(input!=null){
        		try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	}
        }
    	return prop;
	}
	
    public static int generateUniqueId() {      
        UUID idOne = UUID.randomUUID();
        String str=""+idOne;        
        int uid=str.hashCode();
        String filterStr=""+uid;
        str=filterStr.replaceAll("-", "");
        return Integer.parseInt(str);
    }
    
    private static volatile SecureRandom numberGenerator = null;
    private static final long MSB = 0x8000000000000000L;

    public static String unique() {
        SecureRandom ng = numberGenerator;
        if (ng == null) {
            numberGenerator = ng = new SecureRandom();
        }

        return Long.toHexString(MSB | ng.nextLong()) + Long.toHexString(MSB | ng.nextLong());
    }  
}
