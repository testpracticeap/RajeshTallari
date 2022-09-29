package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Message {
	public List<SampleResponse> messageList;
	 
    // Method to return the list
    // of employees
    public List<SampleResponse> getMessageList()
    {
  
        if (messageList == null) {
  
            messageList= new ArrayList<>();
  
                   
        }
  
        return messageList ;
  
           
    }
  
    public void
    setMessageList(
        List<SampleResponse> messageList)
    {
        this.messageList= messageList;
    }

}


