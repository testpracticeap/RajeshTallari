package com.example.demo;

public class MessageDAO {
	public static Message list = new Message();



	//This static block is executed
	//before executing the main
	//block



	static
	{

	   // Creating a few employees
	    // and adding them to the list
	    list.getMessageList().add(new SampleResponse( 2,"kumar","qwer"));
	    list.getMessageList().add(new SampleResponse(3, "mani","zxcv"));    
	}



	//Method to return the list
	public Message getAllMessages()
	{
	   return list;
	   
	}
	    // Method to add an employee
	    // to the employees list
	    public void addMessage(SampleResponse message)
	{
	    list.getMessageList().add(message);
	       
	}

}
