# Spring boot Camel REST + Swagger

An example application that shows how to configure spring boot + Camel with Spring JavaConfig and Camel's Swagger 
support with no web.xml.

## Quick Start

This project is built with [Spring Boot](http://projects.spring.io/spring-boot/) and uses 
[Apache Camel](http://camel.apache.org) for its REST API. 

To run this project use:

1) start git server ( we are using gitlib. you can also use github)
2) run the config-server
3) run the Eureka-server
4) run the hystrix-server
5) run the zipking-server
6) start the mongodb server ( mongod)
7) start the application "Location" (from eclipse by runing spring-boot or using maven " mvn spring-boot:run")
8) validate that the mongodb collection "Geocodings" was created
	8.1) > show dbs 
	8.2) > use demo 
	8.3) > db.Geocodings.find()
9) post a message
					 {
					  "list": [
							{
							  "geocodingId": null,
							  "longitude": "-84.100033",
							  "latitude": "33.969601",
							  "address": "2651 Satellite Blvd, Duluth, GA 30096, USA"
							}
					  ]
					}

10) Data grid test (hazelcast)
11) scaling location
13) scaling the config-server

==============   links  ==============================
Then navigate to [http://localhost:8181/docs/index.html](http://localhost:8181/docs/index.html) to 
see the Swagger documentation.

The health check url: http://localhost:8181/health
hystrix:http://localhost:9023/
Eureka (service registry and discovery): http://localhost:8761/

orchestration : http://localhost:8086/1/33.969601/-84.100033/integration


 -- actuator

https://location.apps.px-01.cf.t-mobile.com/health
https://location.apps.px-01.cf.t-mobile.com/metrics
https://location.apps.px-01.cf.t-mobile.com/beans
https://location.apps.px-01.cf.t-mobile.com/configprops
https://location.apps.px-01.cf.t-mobile.com/mappings
https://location.apps.px-01.cf.t-mobile.com/env
https://location.apps.px-01.cf.t-mobile.com


-- rest call
	https://localhost:8181/Location/api/ping
	https://localhost:8181/Location/api/location/latitude/33.969601/longitude/-84.100033
	http://localhost:8181/1/33.969601/-84.100033/integration
	http://localhost:8181/Location/api/location/latitude/33.969601/longitude/-84.100033
	http://localhost:8181/Location/api/location/latitude/33.969601/longitude/-84.100033
	http://localhost:8181/docs/index.html


=================google key =============
google key:  AIzaSyC8-Qu9AKJuP2HohE6pQUmk--R4KWMmkZU 