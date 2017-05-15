package com.dodo.mongo.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.dodo.LocationApplication;
import com.mongodb.Mongo;



@Configuration
@EnableMongoRepositories
@ComponentScan(basePackageClasses = {LocationApplication.class})
@PropertySource("classpath:application.yml")
public class MongoConfiguration extends AbstractMongoConfiguration {


    @Override
    protected String getDatabaseName() {
        return "demo";
    }



    @Override
    public Mongo mongo() throws Exception {
        /**
         *
         * this is for a single db
         */

         return new Mongo();


        /**
         *
         * This is for a relset of db's
         */

       // return new Mongo(new ArrayList<ServerAddress>() {{ add(new ServerAddress("127.0.0.1", 27017)); add(new ServerAddress("127.0.0.1", 27027)); add(new ServerAddress("127.0.0.1", 27037)); }});

    }

    @Override
    protected String getMappingBasePackage() {
        return "com.dodo.model";
    }

}
