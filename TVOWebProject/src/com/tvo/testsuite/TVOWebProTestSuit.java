package com.tvo.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.tvo.testcases.*;

@RunWith(Suite.class)
@SuiteClasses({
	           TVOWebProFunctionalityTest.class, 
	           TVOWebProNavigationTest.class,
	           TVOWebProCompatabilityTest.class
	           })
public class TVOWebProTestSuit {

}
