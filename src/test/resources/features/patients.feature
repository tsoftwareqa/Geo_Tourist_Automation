Feature: Manage patient scenarios on dashboard

@SmokeTest
  Scenario: Validate search patient by patient name
    Given AdminUser is on Home page of application and login
    When Search the patient by name
    | SearchType |
    | Patient    |
    Then Verify searched record
    
@SmokeTest
  Scenario: Validate deactivate patient
    Given AdminUser is on Home page of application and login
    When Search the patient by name
    | SearchType |
    | Patient    |
    Then update status of patient
    | Status     |
    | Deactivate |
    
@SmokeTest
  Scenario: Validate activate patient
    Given AdminUser is on Home page of application and login
    When Search the patient by name
    | SearchType |
    | Patient    |
    Then update status of patient
    | Status   |
    | Activate |
    
@SmokeTest
  Scenario: Validate filter patient record by inactive status
    Given AdminUser is on Home page of application and login
    When Select Inactive status from dropdown
    Then verify searched records