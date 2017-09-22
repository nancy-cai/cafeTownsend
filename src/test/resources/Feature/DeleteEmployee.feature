Feature: Delete feature

@delete-employee @happy-case
		Scenario Outline: Delete employee from the Landing page button
			Given user is logged in to page
			And Employee with name "<firstName>", "<lastName>" exists
			When user select name "<firstName>", "<lastName>" from the list
			When user clicks Delete on the landing page
			And user accept the alert
			Then user should not see employee with name "<firstName>", "<lastName>" in the list
			
			Examples:
			|firstName   |lastName           |
			|test        |deleteFromLandPage |
			
			
@delete-employee @happy-case
		Scenario Outline: Delete employee from the edit page
			Given user is logged in to page
			And Employee with name "<firstName>", "<lastName>" exists
			When user select name "<firstName>", "<lastName>" from the list
			When user clicks Edit on the landing page
			And user clicks Delete button on the edit page
			And user accept the alert
			Then user should not see employee with name "<firstName>", "<lastName>" in the list
			
			Examples:
			|firstName   |lastName           |
			|test        |deleteFromEditPage |			
			

@cancel-delete-employee 			
		Scenario: Abort the deletion for an employee
			Given user is logged in to page
			And Employee with name test cancelDelete exists
			When user select name test cancelDelete from the list
			When user clicks Delete on the landing page
			And user decline the alert
			Then employee should still exists in the list