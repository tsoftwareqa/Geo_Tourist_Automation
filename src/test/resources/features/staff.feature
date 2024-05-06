Feature: Manage staff scenarios on dashboard

@SmokeTest
  Scenario: Validate add staff member and verify
    Given AdminUser is on Home page of application and login
    When Navigate to Staff menu
    And Create staff account
    | StaffType | ZipCode | Credentials             | StateOfLicense |
    | FTC       | 35201   | (MD) Doctor of Medicine | Alabama        |
    Then Verify created staff record
    
@SmokeTest
  Scenario: Validate search staff by staff name
    Given AdminUser is on Home page of application and login
    And Navigate to Staff menu
    When Search the staff by name
    | SearchType |
    | Staff      |
    Then Verify searched record
    
@SmokeTest
  Scenario: Validate deactivate staff
    Given AdminUser is on Home page of application and login
    And Navigate to Staff menu
    When Search the staff by name
    | SearchType |
    | Staff      |
    Then update status of staff
    | Status     |
    | Deactivate |
    
@SmokeTest
  Scenario: Validate activate patient
    Given AdminUser is on Home page of application and login
    And Navigate to Staff menu
    When Search the staff by name
    | SearchType |
    | Staff      |
    Then update status of staff
    | Status   |
    | Activate |
    
@SmokeTest
  Scenario: Validate filter patient record by inactive status
    Given AdminUser is on Home page of application and login
    And Navigate to Staff menu
    When Select Inactive status from dropdown
    Then verify searched records