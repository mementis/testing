# Testing Homework

* Selenium
* Gherkin
* OpenJDK14

## Features

Using Gherkin, we are creating the features with steps for our testing scenario

Example: 
```Selenium
 Scenario: Successful Login and Logout with Valid Credentials
    Given User lands on homepage
    When User navigates to SignIn Page
    And User enters valid username and password
    Then User gets access to user's account
    Then User clicks on SignOut button
    Then User is no longer logged in
```

## Glue code

The glue code is written using Selenium.

Example:

```java
    driver.findElement(By.name("email_create")).sendKeys(TestUtils.generateEmail());
    driver.findElement(By.name("SubmitCreate")).click();
```