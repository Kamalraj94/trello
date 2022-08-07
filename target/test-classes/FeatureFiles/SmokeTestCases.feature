@SmokeTest
Feature: Validation of UI and Rest API test cases for Trello Application
 

  @TestCase_1
  Scenario: To validate the Board creation functionality of the Trello Application
    Given Launch the Application 
    When Enter the valid username and password 
    And Login should be successfull 
      
     
  @TestCase_2
  Scenario: To check the functionality of Creating List , Cards and moving task between list
    Given Launch the Application 
    When Enter the valid username and password 
    And Login should be successfull 
    When Create new board and Enter Title
    Then Validate the cards addition functionality for the list named "QA Task"
        | Test Data creation |
        | InSprint Auto |
        | Test metrics |    
    And Moving the task from the list
        | Test Data creation - Done |
        | InSprint Auto - Doing |
    Then Editing the task on the list 
        | Edited Task | Description:Just adding description to the task |      
        
        
   @TestCase_3
   Scenario: To verify API call functionality for Board , List and Card
   Given Create a board through API call
   And Get the board name through API call
   Then Create a list for the board through API call as "QA Task"
   And Create a card for the list through API call as "Test case creation"
   Then Delete a board through API call
   
  