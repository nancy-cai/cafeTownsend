Feature: Login
@LoginSuccess
	Scenario Outline: Login with valid credentials
		Given user is on Login page
		And Login form displayed
		When user enters username "<userName>"
		And user enters password"<password>"
		And user clicks the Login button
		Then user should see "<userName>" as the username in greeting message
		
		Examples:
		|userName     |password   |
		|Luke         |Skywalker  |
		
	
@LoginFailureWrong
	Scenario Outline: Login with invalid credentials
		Given user is on Login page
		And Login form displayed
		When user enters username "<userName>"
		And user enters password"<password>"
		And user clicks the Login button
		Then user should see "<errorMessage>"
		
		Examples:
		|userName     |password   |errorMessage									  |
		|Luke         |12         |Invalid username or password!	|
		|Lu           |Skywalker  |Invalid username or password!	|
		|Lu           |12         |Invalid username or password!	|
		
		
@LoginFailureEmpty		
	Scenario Outline: Failed login with empty credential
		Given user is on Login page
		And Login form displayed
		When user enters username "<userName>"
		And user enters password"<password>"
		And user clicks the Login button
		Then user should be unable to proceed with login
		
		Examples:
		|userName     |password   |
		|Luke         |           |
		|             |Skywalker  |
		|             |           |