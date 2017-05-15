package com.dodo.hazelcast;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.dodo.model.Geocodings;

public class HzSharedRepository {
    private String messageUid;
    private List<String> recipients;
    private String sender;
	private Geocodings geocodings;
	
	@Cacheable("geocodings")
	public Geocodings fetAllGeocoding(){
		return geocodings;
	}
}
