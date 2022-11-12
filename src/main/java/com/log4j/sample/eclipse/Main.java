package com.log4j.sample.eclipse;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author vadim
 *
 */
public class Main {

	static final Logger rootLogger = LogManager.getRootLogger();
	static final Logger userLogger = LogManager.getLogger(User.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		rootLogger.fatal("RootLogger: In fatal message");
		rootLogger.error("RootLogger: In error message");
		rootLogger.warn("RootLogger: In warn message");
		rootLogger.info("RootLogger: In info message");
		rootLogger.debug("RootLogger: In debug message");
		rootLogger.trace("RootLogger: In trace message");

		User user = new User();
		user.setName("Anakin");
		user.setLastName("Skywalker");

		userLogger.info(user.showMeMessage());
		userLogger.info(user.giveMeASign());

		rootLogger.info("RootLogger: " + user.showMeMessage());

		// debug
		if (rootLogger.isDebugEnabled()) {
			rootLogger.debug("RootLogger: In debug message");
			userLogger.debug("UserLogger in debug");
		}

		try {
			User userNull = new User();
			userNull.getName().toString();
		} catch (NullPointerException ex) {
			userLogger.error("error message: " + ex.getMessage());
			userLogger.fatal("fatal error message: " + ex.getMessage());
		}
	}

}
