package com.ice.example.dao.impl;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ice.example.bean.RoncooUserLog;

public interface RoncooUserLogDao extends JpaRepository<RoncooUserLog, Integer> {

	RoncooUserLog findByUserName(String string);  //自动与实体检测 然后生成方法sql语句
	
	RoncooUserLog findByUserNameAndUserIp(String userName ,String userIp);

	org.springframework.data.domain.Page<RoncooUserLog> findByUserName(String string, Pageable pageable); 
	
	//如果自带的没有满足的可以 自己加query注解写sql/hql  @Query(value = "select u from RoncooUserLog u where u.userName=?1") 优先级高
	
}
