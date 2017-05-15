package com.dodo.hazelcast;

import com.dodo.LocationApplication;
import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackageClasses = {LocationApplication.class})
@PropertySource("classpath:application.yml")
public class HazelcastConfiguration {
	 @Bean
	 public Config config() {
	   Config config = new Config(); 
	   config.setInstanceName("hazeltcast-cache");
	   config.setProperty("hazelcast.logging.type","slf4j");
	   
	   MapConfig clusterCache = new MapConfig();
	   clusterCache.setTimeToLiveSeconds(3600);
	   clusterCache.setEvictionPolicy(EvictionPolicy.LRU);
	   config.getMapConfigs().put("locationClusterCache", clusterCache);

	   MapConfig localCache = new MapConfig();
	   localCache.setTimeToLiveSeconds(3600);
	   localCache.setEvictionPolicy(EvictionPolicy.LRU);
	   config.getMapConfigs().put("locationLocalCache", localCache);
	   return config;
	 }
	 
/*	 @Bean
	 public Config prdconfig(){
		 return new Config().addMapConfig( 
				  new MapConfig()
				    .setName("accepted-messages")
				    .setEvictionPolicy(EvictionPolicy.LRU)
				    .setTimeToLiveSeconds(2400))
				  .setProperty("hazelcast.logging.type","slf4j");
	 }*/
}
