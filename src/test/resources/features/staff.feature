Feature: Manage staff scenarios on dashboard

@SmokeTest
  Scenario: Validate add staff member and verify
    Given AdminUser is on Home page of application and login
    When Navigate to Staff menu
    And Create staff account
    | StaffType | ZipCode | Credentials             | StateOfLicense |
    | FTC       | 35201   | (MD) Doctor of Medicine | Alabama        |
    Then Verify created staff record