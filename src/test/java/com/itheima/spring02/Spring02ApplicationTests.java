package com.itheima.spring02;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.BookDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Book;
import com.itheima.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.List;

@SpringBootTest
class Spring02ApplicationTests {

	@Autowired
	private BookDao bookDao;

	@Autowired
	private UserDao userDao;

	@Test
	void testByID() {
		Book book = bookDao.getById(2);
		System.out.println(book);
	}

	@Test
	void testGetAll(){
//		LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper();
//		lqw.select(User::getId);
		QueryWrapper<User> lqw = new QueryWrapper<>();
		List<User> userList = userDao.selectList(null);
		System.out.println(userList);
	}

	@Test
	void testInsert(){
		User user = new User();
		user.setUsername("siwi");
		user.setAddress("汉口");
		user.setGender("男");
		user.setPassword("1q2w3e4r");
		userDao.insert(user);
	}

	@Test
	void testUpdate(){
		User user = new User();
		user.setId(2L);
		user.setUsername("baby");
		userDao.updateById(user);
	}

	@Test
	void testPage(){
		IPage page = new Page(2, 2);
		userDao.selectPage(page, null);
		System.out.println("当前页码" + page.getCurrent());
		System.out.println("data:" + page.getRecords());
	}

}
