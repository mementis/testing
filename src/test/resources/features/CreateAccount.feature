#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Create an Account
  

  @tag1
  Scenario: Successful Account Creation with Valid Credentials
    Given User lands on authentication page
    When User submits valid e-mail into e-mail address box
    Then User gets redirected to account creation page
	When User fills form with valid credentials
	And User submits form
	Then User is redirected to user's account
