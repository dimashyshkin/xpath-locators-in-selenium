package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LocatorTests extends Base {

	@Test
	@Parameters({"locator"})
	public void locatorTest(String locatorString) {
		log.info("Starting locatorTest for " + locatorString);
		openPage();
		By locatorBy = getBy(locatorString);

		WebElement emailInputField = driver.findElement(locatorBy);
		log.info("Element located");
		log.info("Element is displayed: " + emailInputField.isDisplayed());
	}


	private By getBy(String locator) {
		switch (locator) {
		// E-mail field
		case "relativeXPath":
			return By.xpath("//input[@id='email']");
			
		case "absoluteXPath":
			return By.xpath("/html/body/div/div/div/form/div/div/input");
			
		case "id":
			return By.id("email");
			
		case "css":
			return By.cssSelector("input");
			
		case "name":
			return By.name("email");
			
		case "tag":
			return By.tagName("input");
			
		// 	Retrieve password button
		case "className":
			return By.className("radius");
			
		// 	Elemental Selenium link
		case "linkText":
			return By.linkText("Elemental Selenium");
			
		case "partialLinkText":
			return By.partialLinkText("Elemental");

		default:
			return null;
		}
	}


	private void openPage() {
		// open the page
		String url = "http://the-internet.herokuapp.com/forgot_password";
		driver.get(url);
		log.info("Page is opened");
	}

}
