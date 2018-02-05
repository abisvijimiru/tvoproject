package com.tvo.testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TVOWebProSecurityTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("Sec Befor");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Sec Befor");
	}

	@Test
	public void test() {
		System.out.println("Sec during test ");
		}

}
