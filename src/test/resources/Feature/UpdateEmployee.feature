Feature: update features

@update-happy-case
	Scenario Outline: Update an existing employee happy case
		Given user has logged in
		And Employee with name test updateSuccess exists
		When user select test updateSuccess from the list
		When user clicks the Edit button
		And user changes firstname to "<newFirstName>"
		And user changes lastname to "<newLastName>"
		And user changes start date to "<newStartDate>"
		And user changes email to "<newEmail>"
		And user submit the Updated form
		When user select new full name from the list "<newFirstName>", "<newLastName>"
		Then user should see updated  details "<newFirstName>", "<newLastName>", "<newStartDate>","<newEmail>"
	
		Examples:
		|newFirstName    |newLastName           |newStartDate  |newEmail         |
		|test            |updatePastDate        |2010-09-19    |update@test.com  |
		|test            |updateFutureDate      |2025-09-19    |update@test.com  |
	

@update-fail-case
	Scenario Outline: Update an existing employee happy case
		Given user has logged in
		And Employee with name test updateFail exists
		When user select test updateFail
		When user clicks the Edit button
		And user changes firstname to "<newFirstName>"
		And user changes lastname to "<newLastName>"
		And user changes start date to "<newStartDate>"
		And user changes email to "<newEmail>"
		And user submit the Updated form
		Then user should be unable to proceed with update
		
		Examples:
		|newFirstName    |newLastName           |newStartDate  |newEmail      |
		|test            |createNewWrongDate    |2010-29-10    |test@test.com |
		|test            |createNewWrongEmail   |2025-09-15    |test          |
		|                |createNewNoFirstName  |2025-09-15    |test@test.com |
		|testNoLastName  |                      |2025-09-15    |test@test.com |
		
	

@cancel-update-employee 
	Scenario: Abort updating an existing employee 
		Given user has logged in
		And Employee with name test updateCancel exists
		When user select test updateCancel
		When user clicks the Edit button
		And user clicks the Back button
		Then user should go back to the landing page
