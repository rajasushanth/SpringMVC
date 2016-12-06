package com.library.configuration;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

@Configuration
public class DBConfiguration {
	
	@Bean
	@Scope(scopeName=ConfigurableBeanFactory.SCOPE_SINGLETON)
	public MongoDatabase getDB() {
		MongoClient mongoClient = null;
		MongoDatabase database = null;
		StringBuilder uriBuilder = new StringBuilder();
		uriBuilder.append("mongodb://");
		uriBuilder.append(System.getenv("MONGODB_USER"));
		uriBuilder.append(":");
		uriBuilder.append(System.getenv("MONGODB_PASSWORD"));
		uriBuilder.append("@");
		uriBuilder.append(System.getenv("MONGODB_PORT_27017_TCP_ADDR"));
		uriBuilder.append(":");
		uriBuilder.append(System.getenv("MONGODB_SERVICE_PORT"));
		uriBuilder.append("/?authSource=");
		uriBuilder.append(System.getenv("MONGODB_DATABASE"));
		uriBuilder.append("&authMechanism=SCRAM-SHA-1");
		
		String uri = uriBuilder.toString();
		//uri = "mongodb://sushclient:client55@localhost:27018/?authSource=sampledb&authMechanism=SCRAM-SHA-1";
		System.out.println("********MongoDB URL::"+uri+" *********");
		try{
			mongoClient = new MongoClient(new MongoClientURI(uri));
		}catch(Exception e) {
			System.out.println("Exception in DBConfiguration::"+e.getMessage());
			mongoClient.close();
		}
		database = mongoClient.getDatabase(System.getenv("MONGODB_DATABASE"));
		return database;
	}
	
}
