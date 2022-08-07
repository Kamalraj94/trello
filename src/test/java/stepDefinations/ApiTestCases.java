package stepDefinations;

import java.io.IOException;
import com.jayway.restassured.path.json.JsonPath;
import Utilities.API_Utils;
import Utilities.CustomizedUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class ApiTestCases {

	API_Utils api = new API_Utils();
	CustomizedUtils utils = new CustomizedUtils();
	static String BoardName,Id,BoardId,listId ;
	JsonPath json = null;

	@And("^Get the board name through API call$")
	public void Get_the_board_name_through_API_call() throws IOException {
		json = api.getRequestForBoard(BoardId);
		Id = json.getString("id");
	}

	@Given("^Create a board through API call$")
	public void Create_board() throws IOException {
		BoardName = utils.SprintNameGeneration();
		json = api.postRequestForBoardCreation(BoardName);
		BoardId = json.getString("shortUrl").split("/")[4];
	}

	@Then("^Create a list for the board through API call as \"([^\"]*)\"$")
	public void Create_list(String ListName) throws IOException {
		json = api.postRequestForListCreation(ListName, Id);
		listId = json.getString("id");
	}

	@And("^Create a card for the list through API call as \"([^\"]*)\"$")
	public void Create_card(String cardName) throws IOException {
		json = api.postRequestForcardCreation(cardName, listId);
	}

	@And("^Delete a board through API call$")
	public void Delete_board() throws IOException {
		api.deleteRequestForBoardDeletion(BoardId);
	}

}
