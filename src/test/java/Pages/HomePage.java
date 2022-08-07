package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

	By loginButton_1 = By.xpath("(//a[contains(text(),'Log in')])[1]");
	By LoginButton_2 = By.id("login");
	By LoginButton_3 = By.xpath("(//span[contains(text(),'Log in')])[1]");
	By EnterEmail = By.xpath("//input[@placeholder='Enter email']");
	By EnterPassword = By.xpath("//input[@placeholder='Enter password']");
	By BackToHome = By.xpath("//span[contains(text(),'Trello Workspace')]");
	By UserAccount = By.xpath("//div[@title='trello account (useraccount197)']");
	By Logout = By.xpath("//button[@data-test-id='header-member-menu-logout']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement LoginButton_1() {
		return driver.findElement(loginButton_1);
	}

	public WebElement LoginButton_2() {
		return driver.findElement(LoginButton_2);
	}

	public WebElement LoginButton_3() {
		return driver.findElement(LoginButton_3);
	}

	public WebElement EnterEmail() {
		return driver.findElement(EnterEmail);
	}

	public WebElement EnterPassword() {
		return driver.findElement(EnterPassword);
	}
	
	public WebElement backToHome() {
		return driver.findElement(BackToHome);
	}
    
	public WebElement userAccount() {
		return driver.findElement(UserAccount);
	}
	
	public WebElement Logout() {
		return driver.findElement(Logout);
	}
}
