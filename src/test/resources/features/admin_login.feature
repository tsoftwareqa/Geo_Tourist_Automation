Feature: Manage login and logout session for admin

@SmokeTest1
  Scenario: Validate admin login to application with valid credentials
    Given AdminUser is on Home page of application and login
    When AdminUser verify dashboard label
   
@SmokeTest
  Scenario: Validate admin login to application with valid credentials and logout
    Given AdminUser is on Home page of application and login
    When AdminUser clicks on logout option
    Then AdminUser should logout from application and navigate to login screen
    
@SmokeTest
  Scenario: Validate admin login for invalid credentials
    Given AdminUser is on Home page of application and login with invalid credentials
    When AdminUser verify error validation message