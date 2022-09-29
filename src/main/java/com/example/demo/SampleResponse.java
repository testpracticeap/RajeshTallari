package com.example.demo;

public class SampleResponse {
	//message,id,name
    
    
    
    private String Name;
    private long id;
    private String Address;
    public SampleResponse() {
        
    }
    public SampleResponse(long id, String Name, String Address) {
        this.id = id;
        this.Name = Name;
        this.Address =Address;
        
    }

  public String getName() {
        return Name;
  }

  public void setName(String Name) {
        this.Name = Name;
    }

  public long getId() {
        return id;
    }

  public void setId(long id) {
        this.id = id;
    }
  public String getAddress() {
        return Address;
    }

   public void setAddress(String Address) {
        this.Address = Address;
    }

}
