
Feature: Login action
  

  
  Scenario: Successful Login and Logout with Valid Credentials
    Given User lands on homepage
    When User navigates to SignIn Page
    And User enters valid username and password
    Then User gets access to user's account
		Then User clicks on SignOut button
		Then User is no longer logged in
	 
	
  
