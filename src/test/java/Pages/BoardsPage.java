package Pages;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BoardsPage {

	public WebDriver driver;

	public BoardsPage(WebDriver driver) {
		this.driver = driver;
	}

	static String parameter = null;
	By createButton = By.xpath("//p[contains(text(),'Create')]");
	By createBoardButton = By.xpath("//span[contains(text(),'Create board')]");
	By EnterBoardTitle = By.xpath("//input[@data-test-id='create-board-title-input']");
	By SubmitBoard = By.xpath("//button[@data-test-id='create-board-submit-button']");
	By EnterListTitle = By
			.xpath("//textarea[@placeholder='Enter a title for this card…'] | //input[@class='list-name-input']");
	By AddList = By.xpath("//input[@value='Add list'] | //input[@value='Add card']");
	By EnterCard_1 = By.xpath("//span[contains(text(),'Add a card')]");
	By EnterCard_2 = By.xpath("//textarea[@placeholder='Enter a title for this card…']");
	By AddCard = By.xpath("//input[@value='Add card']");
	By clickCards = By
			.xpath("//span[contains(text(),'Add a card')] | //a[@class='open-card-composer js-open-card-composer']");
	By AddCard_Doing = By.xpath("(//span[contains(text(),'Add a card')])[2]");
	By AddCard_Done = By.xpath("(//span[contains(text(),'Add a card')])[3]");
	By clickEdit_1 = By.xpath("(//a[@class='list-card js-member-droppable ui-droppable ui-sortable-handle'])[1]");
	By clickEdit_2 = By.xpath("//textarea[@class='mod-card-back-title js-card-detail-title-input']");
	By AddDescription = By.xpath("//textarea[@placeholder='Add a more detailed description…']");
	By saveDescription = By.xpath("(//input[@Value='Save'])[1]");
	By closeDialog = By.xpath("//class[@aria-label='Close dialog']");

	public WebElement clickEdit_1() {
		return driver.findElement(clickEdit_1);
	}

	public WebElement clickEdit_2() {
		return driver.findElement(clickEdit_2);
	}

	public WebElement AddDescription() {
		return driver.findElement(AddDescription);
	}

	public WebElement saveDescription() {
		return driver.findElement(saveDescription);
	}

	public WebElement closeDialog() {
		return driver.findElement(closeDialog);
	}

	public WebElement clickCards() {
		return driver.findElement(clickCards);
	}

	public WebElement createButton() {
		return driver.findElement(createButton);
	}

	public WebElement createBoardButton() {
		return driver.findElement(createBoardButton);
	}

	public WebElement EnterBoardTitle() {
		return driver.findElement(EnterBoardTitle);
	}

	public WebElement SubmitBoard() {
		return driver.findElement(SubmitBoard);
	}

	public WebElement getTitleName(String passValue) {
		parameter = passValue;
		By getTitleName = By.xpath(
				"//a[@aria-label='" + parameter + " (currently active)'] | //a[@aria-label='" + parameter + "']");
		return driver.findElement(getTitleName);
	}

	public WebElement dragElement(String passValue) {
		parameter = passValue;
		By dragElement = By.xpath("//Span[contains(text(),'" + parameter + "')]");
		return driver.findElement(dragElement);
	}

	public WebElement EnterListTitle() {
		return driver.findElement(EnterListTitle);
	}

	public WebElement AddList() {
		return driver.findElement(AddList);
	}

	public WebElement EnterCard_1() {
		return driver.findElement(EnterCard_1);
	}

	public int EnterCard_size() {
		return driver.findElements(EnterCard_1).size();
	}

	public WebElement EnterCard_2() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver.findElement(EnterCard_2);
	}

	public WebElement AddCard() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver.findElement(AddCard);
	}

	public WebElement AddCard_Doing() {
		return driver.findElement(AddCard_Doing);
	}

	public WebElement AddCard_Done() {
		return driver.findElement(AddCard_Done);
	}

}
