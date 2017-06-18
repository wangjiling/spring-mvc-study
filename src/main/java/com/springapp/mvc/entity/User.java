package com.springapp.mvc.entity;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection="User")
public class User implements Serializable{
    private static final long serialVersionUID = -5490587578995456669L;

    @Id
	private String id;
    @Indexed
    private String name;
    private String password;


    public User(){

    }

    public User(String name,String password) {
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toJson(){
    	ObjectMapper mapper = null;
    	try{
    		mapper = new ObjectMapper();
        	return mapper.writeValueAsString(this);
    	}catch(Exception e){
    		e.printStackTrace();
    		return "";
    	}
    }
}
