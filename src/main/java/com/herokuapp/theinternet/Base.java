package com.herokuapp.theinternet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

	protected Logger log;
	protected WebDriver driver;


	@BeforeMethod
	protected void setUp(ITestContext ctx) {
		setCurrentThreadName();
		String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}


	@AfterMethod
	protected void tearDown() {
		driver.quit();
	}


	/** Sets thread name which includes thread id */
	private void setCurrentThreadName() {
		Thread thread = Thread.currentThread();
		String threadName = thread.getName();
		String threadId = String.valueOf(thread.getId());
		if (!threadName.contains(threadId)) {
			thread.setName(threadName + " " + threadId);
		}
	}
}
