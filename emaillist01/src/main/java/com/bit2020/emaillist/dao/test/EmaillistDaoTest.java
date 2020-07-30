package com.bit2020.emaillist.dao.test;

import java.util.List;

import com.bit2020.emaillist.dao.EmaillistDao;
import com.bit2020.emaillist.vo.EmaillistVo;

public class EmaillistDaoTest {

	public static void main(String[] args) {
		//testInsert();
		testSelectList();
	}

	public static void testSelectList() {
		List<EmaillistVo> list = new EmaillistDao().findAll();
		if(list.size() == 2) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}
	
	public static void testInsert() {
		EmaillistVo vo = new EmaillistVo();
		vo.setFirstName("둘");
		vo.setLastName("리");
		vo.setEmail("dooly@gmail.com");
		
		boolean result = new EmaillistDao().insert(vo);
		if(result) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}
}