package com.herokuapp.theinternet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AxesTests extends Base {

	@Test
	public void axesTest() {
		log.info("Starting axes test");
		openPage();
		String email = "fbach@yahoo.com";

		// Get row for specific email
		WebElement row = driver.findElement(By.xpath("//*[@id='table1']//td[text()='" + email + "']/parent::*"));

		// Print text from this row
		log.info("Row: " + row.getText());

		// Click on delete button for this row

		// One way
		WebElement deleteButton = driver.findElement(By.xpath("//*[@id='table1']//td[text()='" + email
				+ "']/parent::*/child::td/a[@href='#delete']"));
		deleteButton.click();

		// Another way
		// incorrect
		row.findElement(By.xpath("//child::td/a[@href='#delete']"));

		// helper
		List<WebElement> list1 = row.findElements(By.xpath("//child::td/a[@href='#delete']"));
		log.info("List1 size: " + list1.size());

		// correct
		row.findElement(By.xpath("./child::td/a[@href='#delete']"));

		// helper
		List<WebElement> list2 = row.findElements(By.xpath("./child::td/a[@href='#delete']"));
		log.info("List2 size: " + list2.size());

		// also correct
		row.findElement(By.xpath("./descendant::a[@href='#delete']"));

		// helper
		List<WebElement> list3 = row.findElements(By.xpath("./descendant::a[@href='#delete']"));
		log.info("List3 size: " + list3.size());

	}


	private void openPage() {
		// open the page
		String url = "http://the-internet.herokuapp.com/tables#delete";
		driver.get(url);
		log.info("Page is opened");
	}

}
