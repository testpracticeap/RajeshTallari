package com.API.Message;

import org.springframework.stereotype.Repository;

@Repository
public class SampleResponse {

	// message,id, name
	private int id;
	private String todolist;
	public SampleResponse() {
		
	}
	public SampleResponse(int id, String todolist) {
		super();
		this.id = id;
		this.todolist = todolist;
	}
	
	public int getid() {
		return id;
	}
	
	public void setid(int id) {
		this.id=id;
	}
	
	public String gettodolist() {
		return todolist;
	}
	
	public void settodolist(String todolist) {
		this.todolist=todolist;
	}
	
	public void gettodolistvalues() {
	
		PostRequest Post= new PostRequest();
		Post.getid();
		Post.gettodolist();

	}	
}
