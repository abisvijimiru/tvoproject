package com.tvo.testcases;
import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TVOWebProLog4jTestWatcher extends TestWatcher{

	private final Logger logger = Logger.getLogger("TVOWebProLog4jTestWatcher");
    
    @Override
    protected void failed(Throwable e, Description description) {
        logger.error(description + " - Failed", e);
    }
 
    @Override
    protected void succeeded(Description description) {
        logger.info(description + " - Passed");
    }

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
