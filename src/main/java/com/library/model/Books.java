package com.library.model;

import java.util.List;

public class Books {
	
	private _id _id;
	private String name;
	private String author;
	private List<String> genere;
	
	public _id get_id() {
		return _id;
	}
	public void set_id(_id _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public List<String> getGenere() {
		return genere;
	}
	public void setGenere(List<String> genere) {
		this.genere = genere;
	}
	
	
	

}
