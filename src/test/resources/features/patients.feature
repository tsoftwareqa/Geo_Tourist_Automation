Feature: Manage patient scenarios on dashboard

@SmokeTest
  Scenario: Validate search patient by patient name
    Given AdminUser is on Home page of application and login
    When Search the patient by name
    | SearchType |
    | Patient    |
    Then Verify searched record
    
@SmokeTest1
  Scenario: Validate deactivate patient
    Given AdminUser is on Home page of application and login
    When Search the patient by name
    | SearchType |
    | Patient    |
    Then update status of patient
    | Status     |
    | Deactivate |
    
@SmokeTest1
  Scenario: Validate activate patient
    Given AdminUser is on Home page of application and login
    When Search the patient by name
    | SearchType |
    | Patient    |
    Then update status of patient
    | Status   |
    | Activate |