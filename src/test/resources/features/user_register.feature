Feature: Manage user registration

@SmokeTest1
  Scenario: Validate user signup to application with valid credentials
    Given user is on Home page of application and signup
    When user verify dashboard label
   
@SmokeTest
  Scenario: Validate user signup in application with valid credentials and logout
    Given user is on Home page of application and login
    When user clicks on logout option
    Then user should logout from application and navigate to login screen
    
@SmokeTest
  Scenario: Validate user signup with invalid credentials
    Given user is on Home page of application and signup with invalid credentials
    When user verify error validation message