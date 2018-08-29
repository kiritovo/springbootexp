package com.ice.example.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ice.example.bean.RoncooUser;
import com.ice.example.bean.RoncooUserLog;
import com.ice.example.dao.IceUserDao;
import com.ice.example.dao.impl.RoncooUserLogDao;

@Service
public class UserService {
	@Autowired
	private IceUserDao roncooUserDao;
	@Autowired
	private RoncooUserLogDao roncooUserLogDao;

	/**
	 * 用户 注册
	 * 用户插入  然后日志插入 模拟事务处理
	 * @return
	 */
	@Transactional   //spring下面的
	public String register(String name, String ip) {
		// 1.添加用户
		RoncooUser roncooUser = new RoncooUser();
		roncooUser.setName(name);
		roncooUser.setCreateTime(new Date());
		roncooUserDao.insert(roncooUser);
		// 测试使用
		boolean flag = true;
		if (flag) {
			throw new RuntimeException();
		}
		// 2.添加注册日志
		RoncooUserLog roncooUserLog = new RoncooUserLog();
		roncooUserLog.setUserName(name);
		roncooUserLog.setUserIp(ip);
		roncooUserLog.setCreateTime(new Date());
		roncooUserLogDao.save(roncooUserLog);
		return "success";
	}
}
