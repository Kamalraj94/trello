package stepDefinations;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.BoardsPage;
import Pages.HomePage;
import Utilities.AutomationException;
import Utilities.CustomizedUtils;
import Utilities.DriverProperties;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Utilities.ConfigFileReader;
import junit.framework.Assert;

public class UserInterfaceTestCases extends DriverProperties {

	String sprint_name;
	ConfigFileReader config;
	HomePage homepage;
	BoardsPage boardspage;
	static WebDriverWait wait;
	CustomizedUtils utils;

	@Given("^Launch the Application$")
	public void Launch_the_Application() throws IOException {
		pre_setup();
		String url = config.getURL();
		driver.get(url);
	}

	@And("^Enter the valid username and password$")
	public void enter_username_and_password() throws InterruptedException {
		String emailId = config.getEmailID();
		String password = config.getPassword();
		wait.until(ExpectedConditions.elementToBeClickable(homepage.LoginButton_1())).click();
		wait.until(ExpectedConditions.elementToBeClickable(homepage.EnterEmail())).sendKeys(emailId);
		Thread.sleep(1000); // Thread is used to avoid the Login with google/Atlassian confusion
		wait.until(ExpectedConditions.elementToBeClickable(homepage.LoginButton_2())).click();
		wait.until(ExpectedConditions.elementToBeClickable(homepage.EnterPassword())).sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(homepage.LoginButton_3())).click();
	}

	@When("^Create new board and Enter Title")
	public void Create_new_board_and_Enter_Title() {
		sprint_name = utils.SprintNameGeneration();
		wait.until(ExpectedConditions.elementToBeClickable(boardspage.createButton())).click();
		wait.until(ExpectedConditions.elementToBeClickable(boardspage.createBoardButton())).click();
		wait.until(ExpectedConditions.elementToBeClickable(boardspage.EnterBoardTitle())).sendKeys(sprint_name);
		wait.until(ExpectedConditions.elementToBeClickable(boardspage.SubmitBoard())).click();
		String actualValue = boardspage.getTitleName(sprint_name).getText();
		Assert.assertEquals(actualValue, sprint_name);
	}

	@Then("^Validate the cards addition functionality for the list named \"([^\"]*)\"$")
	public void cards_addtion_for_list(String list_name, DataTable inputData) throws Exception {
		boolean a;
		try {
			List<List<String>> rows = inputData.asLists(String.class);
			wait.until(ExpectedConditions.elementToBeClickable(boardspage.EnterListTitle())).sendKeys(list_name);
			wait.until(ExpectedConditions.elementToBeClickable(boardspage.AddList())).click();
			a = boardspage.EnterCard_1().isDisplayed();
			a = boardspage.EnterCard_size() > 1;
			if (!a) {
				boardspage.EnterCard_1().click();
			}
			for (List<String> addCards : rows) {
				wait.until(ExpectedConditions.elementToBeClickable(boardspage.EnterCard_2())).sendKeys(addCards.get(0));
				wait.until(ExpectedConditions.elementToBeClickable(boardspage.AddCard())).click();
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@And("^Moving the task from the list$")
	public void validate_the_cards_editing_and_moving_functionality_of_the_list(DataTable input) {
		List<List<String>> rows = input.asLists(String.class);
		WebElement From;
		WebElement To;
		utils.createList(driver);
		for (List<String> moveCards : rows) {
			String operation = moveCards.get(0);
			From = boardspage.dragElement(moveCards.get(0).split("-")[0].trim());
			if (operation.contains("Doing")) {
				To = boardspage.AddCard_Doing();
			} else {
				To = boardspage.AddCard_Done();
			}
			utils.DragAndDrop(From, To, driver);
		}
	}

	@Then("^Editing the task on the list$")
	public void Editing_the_task_on_the_list(DataTable input) throws InterruptedException {
		List<List<String>> rows = input.asLists(String.class);
		for (List<String> EditFlow : rows) {
			wait.until(ExpectedConditions.elementToBeClickable(boardspage.clickEdit_1())).click();
			wait.until(ExpectedConditions.elementToBeClickable(boardspage.clickEdit_2())).sendKeys(EditFlow.get(0));
			wait.until(ExpectedConditions.elementToBeClickable(boardspage.AddDescription()))
					.sendKeys(EditFlow.get(1).split(":")[1]);
			wait.until(ExpectedConditions.elementToBeClickable(boardspage.saveDescription())).click();
		}
	}

	@Then("^Login should be successfull$")
	public void Login_should_be_successfull() throws AutomationException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean a = homepage.backToHome().isDisplayed();
		if (!a) {
			throw new AutomationException("Homepage is not loaded");
		}
	}

	public void pre_setup() throws IOException {
		start_session();
		wait = new WebDriverWait(driver, 20);
		homepage = new HomePage(driver);
		boardspage = new BoardsPage(driver);
		config = new ConfigFileReader();
		utils = new CustomizedUtils();
	}

	@After
	public void closeBrowser() {
		try {
		driver.quit(); 
		} catch (Exception e) {
			//Handled when driver is not called
		}
		
	}

}
