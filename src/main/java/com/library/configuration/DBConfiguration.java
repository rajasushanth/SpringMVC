package com.library.configuration;

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
		MongoClient mongo = null;
		DB db = null;
		String uri ="mongodb://sushclient:client55@127.0.0.1:27018/?authSource=sampledb&authMechanism=SCRAM-SHA-1";
		try{
			mongo = new MongoClient(new MongoClientURI(uri));
		}catch(Exception e) {
			mongo.close();
		}
		db = mongo.getDB("sampledb");
		return db;
	}
}
