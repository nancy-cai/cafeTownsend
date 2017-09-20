Feature: Create Employee feature
@CreateNew
	Scenario: Create a new employee with valid details
	Given user is logged in
	And the Create button displayed
	Then user click the Create button
	Then user enters firstname "<firstName>"
	And user enters lastname "<lastname>"
	And user enters startDate "<startDate>"
	And user enters email "<email>"
		