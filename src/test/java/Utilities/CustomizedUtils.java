package Utilities;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CustomizedUtils {

	public CustomizedUtils() {

	}

	public void DragAndDrop(WebElement from, WebElement To, WebDriver driver) {
		Actions act = new Actions(driver);
		act.dragAndDrop(from, To).build().perform();
	}

	public String SprintNameGeneration() {
		Random rnd = new Random();
		int num = rnd.nextInt(90) + 10;
		String name = "Sprint " + String.valueOf(num);
		return name;
	}

	public void createList(WebDriver driver) {
		try {
			driver.findElement(By.xpath("//h2[contains(text(),'Doing')]")).isDisplayed();
		} catch (Exception e) {
			driver.findElement(By.xpath("//input[@placeholder='Enter list title…']")).sendKeys("Doing");
			driver.findElement(By.xpath("//input[@value='Add list']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Enter list title…']")).sendKeys("Done");
			driver.findElement(By.xpath("//input[@value='Add list']")).click();
		}

	}
}
