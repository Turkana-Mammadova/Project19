
Feature: Testing Entrance Exam functionality

  Scenario: User can login with valid credentials and move to the Exam menu
    Given Navigate to "https://test.campus.techno.study/"
    When I login using username daulet2030@gmail.com and password "TechnoStudy123@"
    Then Click to the login button
    And I navigate to Entrance Exam menu
    And I click plus button for creating new Entrance Exam


  Scenario Outline: We can create Entrance Exam with the minimum required info

    Given I fill informatin "<Name>" , "<Academic_Period>", "<Grade_level>"
    And I click save button on exam
    Then I should get "created" message
    Examples:
      | Name | Academic_Period | Grade_level |
      | Math | 2019-2020       | BasqarTeam   |
      | Java | 2018-2019       | Techno1    |




  Scenario Outline: We can update information on Entrance Exam
    Given I update informatin "<Name>" , "<Academic_Period>", "<Grade_level>"
    And I click save button on exam
    Then I should get "updated" message
    Examples:
      | Name    | Academic_Period | Grade_level |
      | Math    | 2018-2019       | 6th grade   |
      | Biology | 2019-2020       | 10th grade  |


  Scenario Outline: We can delete the Entrance Exam that we created before
    Given I navigate to Entrance Examinations menu
    When  I delete informatin "<Name>" , "<Academic_Period>", "<Grade_level>"
    Then I should get "deleted" message
    Examples:
      | Name    | Academic_Period | Grade_level |
      | Math    | 2019-2020       | BasqarTeam  |
      | Biology | 2019-2020       | 10th grade  |

