package com.example.demo;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class MessageControl {

  
  @RequestMapping("/sample")
  public SampleResponse Sample(
  @RequestParam(value = "name", defaultValue = "Rajesh") String name,
  @RequestParam(value = "Address ", defaultValue = "Hyderabad") String Address,
  @RequestParam(value = "ID ", defaultValue = "1") int ID )
  {
      SampleResponse response = new SampleResponse();
  	response.setId(1);
      response.setName("Your name is "+name);
      response.setAddress("Your Address is "+Address);
      return response;

 }
  @GetMapping(
          path = "/",
          produces = MediaType.APPLICATION_JSON_VALUE)
    
public Message getMessages()
 {
     MessageDAO messagedao=new MessageDAO();
     return messagedao.getAllMessages();
     
     
         
 }
@PostMapping(
          path = "/",
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE)
    
      public SampleResponse addMessage(
          @RequestBody SampleResponse response)
      {
            MessageDAO messagedao=new MessageDAO();
          Integer id= messagedao.getAllMessages().getMessageList().size()+ 2;
          messagedao.addMessage(response);
          return response;
      }

}
