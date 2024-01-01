
package com.swiigy.log4j;

import org.apache.log4j.Logger;

public class Test {

	final static Logger logger = Logger.getLogger(Test.class);

	public static void main(String[] args) {

		
		  System.out.println("Debug Occured!!"); System.out.println("Info Occured!!");
		  System.out.println("warn Occured!!"); System.out.println("error Occured!!");
		  System.out.println("fatal Occured!!");
		 
		logger.warn("Debug Occured!!");
		logger.error("Debug Occured!!");
		logger.debug("Debug Occured!!");
		logger.info("Debug Occured!!");
		logger.fatal("Debug Occured!!");
		

	}

}
