package com.dodo.mongo.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.dodo.model.Geocoding;
import com.dodo.model.Geocodings;


@Repository
public class GeocodingRepository {

    static final Logger logger = LoggerFactory.getLogger(GeocodingRepository.class);

    @Autowired
    MongoTemplate mongoTemplate;

  //33.969601,-84.100033
    public long countPings() {
        List<Geocoding> results = null;
        
        Query query = new Query();
        query.addCriteria(Criteria.where("longitude").is("33.969601").and("latitude").is("-84.100033"));

        //results = mongoTemplate.find(query, Geocoding.class);
        long count = this.mongoTemplate.count(query, Geocoding.class);
        
        logger.info("Total number of ping geoLocation in the database: {}", count);
        return count;
    }

    /**
     * This will count how many Geocoding Objects I have
     */
    public long countAllGeocodings() {
    	// findAll().size() approach is very inefficient, since it returns the whole documents
    	// List<Geocoding> results = mongoTemplate.findAll(Geocoding.class);
        
    	long total = this.mongoTemplate.count(null, Geocoding.class);
        logger.info("Total number in database: {}", total);
        
        return total;
    }

    
    /**
     * This will get all Geocoding
     */
    public Geocodings getGeocodings(Geocoding geocoding) {
    	 List<Geocoding> results = mongoTemplate.findAll(Geocoding.class);
    	 Geocodings geocodings = new Geocodings();
    	 geocodings.setList(results);
        logger.info("All Geocoding in the database: {}", geocodings);
        
        return geocodings;
    }
    
    /**
     * This will install a new Geocoding object
     */
    public void insertGeocoding(Geocoding g) {
        mongoTemplate.insert(g);
    }

    /**
     * This will install a new list of Geocoding objects
     */
    public void insertGeocoding(List<Geocoding> list) {
        mongoTemplate.insertAll(list);
    }
    
    /**
     * this will create a {@link Geocoding} collection if the collection does not already exists
     */
    public void createGeocodingCollection() {
        if (!mongoTemplate.collectionExists(Geocoding.class)) {
            mongoTemplate.createCollection(Geocoding.class);
        }
    }

    /**
     * this will drop the {@link Geocoding} collection if the collection does already exists
     */
    public void dropGeocodingCollection() {
        if (mongoTemplate.collectionExists(Geocoding.class)) {
            mongoTemplate.dropCollection(Geocoding.class);
        }
    }
}

