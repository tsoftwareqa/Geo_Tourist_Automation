Feature: Manage login and logout session for user

@SmokeTest
  Scenario: Validate user login to application with valid credentials
    Given user is on Home page of application and login
    When user verify dashboard label
   
@SmokeTest
  Scenario: Validate user login to application with valid credentials and logout
    Given user is on Home page of application and login
    When user clicks on logout option
    Then user should logout from application and navigate to login screen
    
@SmokeTest
  Scenario: Validate user login for invalid credentials
    Given user is on Home page of application and login with invalid credentials
    When user verify error validation message

@SmokeTest1
  Scenario: Validate update profile info
    Given user is on Home page of application and login
    When navigate to profile screen
    Then update profile details and validate