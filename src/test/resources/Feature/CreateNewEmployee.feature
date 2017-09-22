Feature: Create New Employee
@create-happy-case
	Scenario Outline: Create a new employee happy case
		Given user is logged in
		And user is on the landing page
		When user clicks the Create button
		And user enters firstname "<firstName>"
		And user enters lastname "<lastName>"
		And user enters startDate "<startDate>"
		And user enters email "<email>"
		And user submit the Create form
		When user select full name from the list"<firstName>", "<lastName>"
		Then user should see correct details "<firstName>", "<lastName>", "<startDate>","<email>"
		
		Examples:
		|firstName       |lastName              |startDate     |email         |
		|test            |createNewPastDate     |2010-09-15    |test@test.com |
		|test            |createNewFutureDate   |2025-09-15    |test@test.com |
		
		
@create-fail-case
	Scenario Outline: Create a new employee happy case
		Given user is logged in
		And user is on the landing page
		When user clicks the Create button
		And user enters firstname "<firstName>"
		And user enters lastname "<lastName>"
		And user enters startDate "<startDate>"
		And user enters email "<email>"
		And user submit the Create form		
		Then user is unable to proceed with creation
		
		Examples:
		|firstName       |lastName              |startDate     |email         |
		|test            |createNewWrongDate    |2010-29-10    |test@test.com |
		|test            |createNewWrongEmail   |2025-09-15    |test          |
		|                |createNewNoFirstName  |2025-09-15    |test@test.com |
		|testNoLastName  |                      |2025-09-15    |test@test.com |
		
		
@cancel-create-employee
	 Scenario: Cancel employee creation
		Given user is logged in
		And user is on the landing page
		When user clicks the Create button
		And user click the Cancel button
		Then user should be taken back to the landing page
	
			