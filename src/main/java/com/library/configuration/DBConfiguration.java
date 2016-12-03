package com.library.configuration;

import java.net.UnknownHostException;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class DBConfiguration {
	
	@Bean
	@Scope(scopeName=ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DB getDB() {
		String uri = "mongodb://sushclient:client55@127.0.0.1:27017/";
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient(new MongoClientURI(uri));
		} catch (UnknownHostException e) {
			System.out.println("********************Exception Occured************************");
			e.printStackTrace();
		}
		DB db = mongoClient.getDB("sampledb");
		return db;
	}
}
