package com.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.library.model.Books;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

@RestController
public class LibraryController {
	
	@Autowired(required=false)
	private DB db;
	
	private final String producerType = "application/json";
	
	@RequestMapping(value="/books", method=RequestMethod.GET, produces={producerType})
	public List<Books> getAllBooks() {
		System.out.println("#############In LibraryController###############");
		if(db != null){
		DBCollection collection = db.getCollection("books");
		DBCursor cursor = collection.find();
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.create();
	    List<Books> booklist = new ArrayList<Books>();
		try {
			   while(cursor.hasNext()) {
				   booklist.add(gson.fromJson(cursor.next().toString(), Books.class));
			   }
		} finally {
			   cursor.close();
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
