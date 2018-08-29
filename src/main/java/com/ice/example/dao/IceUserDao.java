package com.ice.example.dao;

import com.ice.example.bean.RoncooUser;
import com.ice.example.util.base.Page;

public interface IceUserDao {
	int insert(RoncooUser roncooUser);

	int deleteById(int id);

	int updateById(RoncooUser roncooUser);

	RoncooUser selectById(int id);

	Page<RoncooUser> queryForPage(int i, int j, String string);
}
