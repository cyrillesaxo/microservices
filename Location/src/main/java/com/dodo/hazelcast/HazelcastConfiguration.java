package com.dodo.hazelcast;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.dodo.LocationApplication;
import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.NetworkConfig;

@Configuration
@ComponentScan(basePackageClasses = {LocationApplication.class})
@PropertySource("classpath:application.yml")
public class HazelcastConfiguration {
	 @Bean
	 public Config config() {
	   Config config = new Config(); 
	   config.setInstanceName("hazeltcast-cache");
	   config.setProperty("hazelcast.logging.type","slf4j");
	   
	   
	   //If we our instance are in differents machines
	   //There is also 'Hazelcast Discovery SPI'
	   //http://docs.hazelcast.org/docs/2.4/manual/html/ch12s02.html
/*	   NetworkConfig network = config.getNetworkConfig();
	   JoinConfig join = network.getJoin();
	   join.getMulticastConfig().setEnabled(false);
	   join.getTcpIpConfig().addMember("10.45.67.32")
	   .addMember("10.45.67.100")
	   .addMember("localhost")
	   .setRequiredMember("10.45.67.100").setEnabled(true);
	   network.getInterfaces().setEnabled(true).addInterface("10.45.67.*");*/
	   
	   
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
