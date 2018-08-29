package com.ice.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ice.example.bean.RoncooUser;
import com.ice.example.bean.RoncooUserLog;
import com.ice.example.controller.IndexController;
import com.ice.example.dao.IceUserDao;
import com.ice.example.dao.impl.RoncooUserLogDao;
import com.ice.example.service.UserService;
import com.ice.example.util.base.Page;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Springbootdemo21ApplicationTests {
    private MockMvc mvc;
    
    @Autowired
    private IceUserDao roncooUserDao;

   //构造mvc 测试访问页面 
    @Before
    public void befor(){
    	this.mvc=MockMvcBuilders.standaloneSetup(new IndexController()).build();
    }
	@Test
	public void contextLoads() {
		RequestBuilder req =get("/index");
		try {
			mvc.perform(req).andExpect(status().isOk()).andExpect(content().string("hello world!"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/**
 * jdbc测试
 */
	@Test
	public void insert() {
		RoncooUser roncooUser = new RoncooUser();
		roncooUser.setName("测试");
		roncooUser.setCreateTime(new Date());
		int result = roncooUserDao.insert(roncooUser);
		System.out.println(result);
	}

	@Test
	public void delete() {
		int result = roncooUserDao.deleteById(1);
		System.out.println(result);
	}
	@Test
	public void update() {
		RoncooUser roncooUser = new RoncooUser();
		roncooUser.setId(2);
		roncooUser.setName("测试 2");
		roncooUser.setCreateTime(new Date());
		int result = roncooUserDao.updateById(roncooUser);
		System.out.println(result);
	}
	
	@Test
	public void select() {
		RoncooUser result = roncooUserDao.selectById(2);
		System.out.println(result);
	}
	
	// 分页测试
	@Test
	public void queryForPage() {
		Page<RoncooUser> result = roncooUserDao.queryForPage(1, 20, "测试");
		System.out.println(result.getList());
	}


	
	/**
	 * jpa 测试
	 */
	@Autowired
	private RoncooUserLogDao roncooUserLogDao;
	
	
	@Test
	public void insert2() {
		RoncooUserLog entity = new RoncooUserLog();
		entity.setUserName("无境");
		entity.setUserIp("192.168.0.1");
		entity.setCreateTime(new Date());
		roncooUserLogDao.save(entity);
	}

	@Test
	public void delete2() {
		//删除前会select  org.springframework.dao.EmptyResultDataAccessException: No class com.ice.example.bean.RoncooUserLog entity with id 1 exists!
		roncooUserLogDao.delete(1);
	}

	@Test
	public void update2() {
		RoncooUserLog entity = new RoncooUserLog();
		entity.setId(2);
		entity.setUserName("无境 2");
		entity.setUserIp("192.168.0.1");
		entity.setCreateTime(new Date());
		roncooUserLogDao.save(entity);
	}

	@Test
	public void select2() {
		RoncooUserLog result = roncooUserLogDao.findOne(2);
		System.out.println(result);
	}
	
	@Test
	public void select3() {
		RoncooUserLog result = roncooUserLogDao.findByUserName("无境2");
		System.out.println(result);
	}
	
	
	// 分页   org.springframework.data.domain.Page
	@Test
	public void queryForPage2() {
		Pageable pageable = new PageRequest(0, 20, new Sort(new Order(Direction.DESC,"id")));
		org.springframework.data.domain.Page<RoncooUserLog> result = roncooUserLogDao.findByUserName("无境2", pageable);
		System.out.println(result.getContent());
	}
	
	@Test
	public void queryForPage3() {
		Pageable pageable = new PageRequest(0, 20, new Sort(new Order(Direction.DESC,"id")));
		//org.springframework.data.domain.Page<RoncooUserLog> result = roncooUserLogDao.findByUserName("无境2", pageable);
		org.springframework.data.domain.Page<RoncooUserLog> result =roncooUserLogDao.findAll(pageable);
		System.out.println(result.getContent());
	}

	
	/**
	 * 事务的测试
	 * 
	 */
	@Autowired
	private UserService userService;
	
	@Test
	public void register() {
		String result = userService.register("无境", "192.168.1.1");
		System.out.println(result);
	}

}
