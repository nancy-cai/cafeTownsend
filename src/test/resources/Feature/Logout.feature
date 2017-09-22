Feature: Logout feature
@logout
	Scenario: user logout after successfully logged in
		Given user logged in with coorect credentials
		When user clicks the Logout button
		Then user should be taken to the Login page