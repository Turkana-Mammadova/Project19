
Feature: Login Functionality tests for Campus website

  Scenario: User can login with valid credentials
    Given Navigate to "https://test.campus.techno.study/"
    When I login using username daulet2030@gmail.com and password "TechnoStudy123@"
    Then Click to the login button


  Scenario: We can create an employee with the minimum required info
    And I navigate to Employees menu
    And I click plus button for creating new employee
    Given I fill informatin First Name "Turkana", Last Name "Mammadova", Employee ID "3003222", Document Type "Passport" and Document Number "1001"
    When I click save button
    Then I get "created" message



  Scenario Outline: We can update the employee which we have created
    Given I update "<firstname>" , "<lastname>" , "<employeeId>", "<documenttype>" , "<docnumber>"
    And I click save button
    Then I get "updated" message

    Examples:
      | firstname | lastname  | employeeId | documenttype      | docnumber |
      | Alvina    | Mammadova | 3003222    | Passport          | 1001      |
      | Alvina    | Yildiz    | 2223333    | Personal ID       | 2222      |
      | Musab     | Yildiz    | 2223333    | Birth Certificate | 1001      |
      | Cicek     | Aliyev    | 2223333    | Passport          | 8008      |


  Scenario: we can delete the employee we have created
    When I click delete button
    Then I get "deleted" message


