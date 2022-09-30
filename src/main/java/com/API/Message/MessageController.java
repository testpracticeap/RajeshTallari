package com.API.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.API.Message.SampleResponse;
import com.API.Message.PostRequest;


@RestController
public class MessageController {
	
	@RequestMapping(value="/send",method = RequestMethod.POST)
	public SampleResponse Sample(@RequestBody PostRequest Post) {
		SampleResponse response = new SampleResponse();
		response.setid(Post.getid());
		response.settodolist(Post.gettodolist());
		return response;
	}
	
	
	@GetMapping( path="/",
			     produces = MediaType.APPLICATION_JSON_VALUE)
	
	public SampleResponse todo() {
		SampleResponse response = new SampleResponse();
		response.gettodolistvalues();
		return response;
		
		
	}
	
	
	
	
	

	}
	
	
	
	
		
		
	
	
	


