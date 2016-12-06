package com.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.library.model.Books;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@RestController
public class LibraryController {
	
	@Autowired
	private MongoDatabase database;
	
	private final String producerType = "application/json";
	
	@RequestMapping(value="/books", method=RequestMethod.GET, produces={producerType})
	public List<Books> getAllBooks() {
		System.out.println("LibraryController::Processing book request");
		if(database != null){
		MongoCollection<Document> collection = database.getCollection("books");
		List<Document> documents = collection.find().into(new ArrayList<Document>());
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.create();
	    List<Books> booklist = new ArrayList<Books>();
		try {
			   for (Document document : documents) {
				   booklist.add(gson.fromJson(document.toJson() , Books.class));
			   }
		} catch (Exception e) {
			System.out.println("Exception in LibraryController:: "+e.getMessage());
		}
		
		return booklist;
		}else{
			return null;
		}
		
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET, produces=producerType)
	public String test(){
		return "Successfull";
	}

}
