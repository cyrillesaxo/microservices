package com.dodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
@EnableDiscoveryClient
public class ZipkingserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkingserverApplication.class, args);
	}
}
