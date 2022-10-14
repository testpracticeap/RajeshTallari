package RestAPI.RestAPI;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

import io.restassured.response.Response;

public class Get {
	

     @Test
	public void getreq() throws IOException {
//	RestAssured.baseURI="https://gorest.co.in/public/v1/users/";
//	ResquestSpecification httreq= RestAssured.given().header(".header(\"Authorization\",\"Bearer 24f4362e9a1a17afa8ad5da989bae75c6fe09f271913f5a71c27b88726157fed\");
Response response =RestAssured.given()
                    .baseUri("https://gorest.co.in/public/v1/users/")
                    .header("Authorization","Bearer 24f4362e9a1a17afa8ad5da989bae75c6fe09f271913f5a71c27b88726157fed")
	                .when().get("")
                    .then().log().body().extract().response();

//            Object json= com.jayway.jsonpath.JsonPath.read(response.asString(),"$.data[2].id");   
//            String id =json.toString();

               Object json= com.jayway.jsonpath.JsonPath.read(response.asString(),"$.data[2]");   
    //             String id =json.toString();
//               System.out.println(id);
//                ObjectMapper mapper = new ObjectMapper();
//                String id= mapper.writeValueAsString(json);
                
               ObjectMapper mapper = new ObjectMapper();
                String json1 = mapper.writeValueAsString(json);
    
                TypeReference<HashMap<String, Object>> type =new TypeReference<HashMap<String, Object>>(){
                	
                };
                
                HashMap<String, Object> entry = mapper.readValue(json1, type);
                
                for(Entry<String, Object> data1 : entry.entrySet()) {
                	System.out.println(" " + data1.getKey() + " :" + data1.getValue());
                }
                		
                
               
               

               
               
                    
                    
                    
					}







}
