
Feature: Login Features
@LoginSuccess
	Scenario Outline: Login with valid credentials
		Given user is on Login page
		And Login form displayed
		When user enters username "<username>"
		And user enters password"<password>"
		And user clicks the Login button
		Then user should be logged in
		
		Examples:
		|username     |password   |
		|Luke         |Skywalker  |
		
	
@LoginFailureWrong
	Scenario Outline: Login with invalid credentials
		Given user is on Login page
		And Login form displayed
		When user enters username "<username>"
		And user enters password"<password>"
		And user clicks the Login button
		Then user should see "<error message>"
		
		Examples:
		|username     |password   |error message 						  |
		|Luke         |12         |Invalid username or password!    	  |
		|Lu           |Skywalker  |Invalid username or password!   		  |
		|Lu           |12         |Invalid username or password!          |
		
		
@LoginFailureEmpty		
	Scenario Outline: Failed login with empty credential
		Given user is on Login page
		And Login form displayed
		When user enters username "<username>"
		And user enters password"<password>"
		And user clicks the Login button
		Then user should see popup error message
		
		Examples:
		|username     |password   |
		|Luke         |           |
		|             |Skywalker  |
		|             |           |