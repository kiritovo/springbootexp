package com.ice.example.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ice.example.bean.User;

@RestController
@RequestMapping(value="/index")	
public class IndexController {
	
	@Value(value = "${baidu.desc}")
	private String xrandom;
	
	 @RequestMapping	
      public String index(){
		   System.out.println(xrandom);
           return "hello world!";	  
      }
	 @RequestMapping(value="get")	
     public Map<String,String>get(@RequestParam String name){
		 Map<String,String> map =new HashMap<String, String>();
		 map.put("name", name);
		 map.put("value", "hello world index");
          return map;	  
     }
	 
	 @RequestMapping(value="find/{id}/{name}")	
     public User find(@PathVariable int id,@PathVariable String name){
          User user =new User();
          user.setId(id);
          user.setName(name);
          user.setDate(new Date());
		 return user;	  
     }
	
}
