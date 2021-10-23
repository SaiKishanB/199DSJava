package com.mph.testcase;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.mph.testpack.Calculate;
import com.mph.testpack.User;

public class UserTest {
	User user;
	@Before
	public void setUp()  throws java.lang.Exception{
		user = new User();
		System.out.println("@Before called ");
	}
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testUserNameTooShort()
	{
		user.setName("abcde");
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Username is tooooooooooo short :o");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testUserNameTooLong()
	{
		//Throwable excep = assertThrows();
		user.setName(null);
		 
	}
	
	@After
	public  void tearDown() throws java.lang.Exception{
		user= null;
		System.out.println("@After called ");
	}
}