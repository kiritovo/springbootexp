package com.ice.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebController {
    
	private static final Logger log=LoggerFactory.getLogger(WebController.class);
	
	@RequestMapping("/index")
	public String index(ModelMap map){
		map.put("title", "雪糕の家");
		log.info("这里是controller");
    	return "index";  //默认到src/main/resource   ---templates  目录下    这里不加斜杠 不然linux启动服务会报错
     }
}
