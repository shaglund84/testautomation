Feature: Register user at Basketball England

  Scenario: Successful registration
    Given I have entered date of birth "01/01/1990"
    And I have entered first name "Karl"
    And I have entered last name "Kalrsson"
    And I have entered and confirmed email "maodoodo4794@rartg.com"
    And I have entered password "Password12345!"
    And I have confirmed password "Password12345!"
    And I have checked terms and conditions
    And I have checked Over 18 and code of conduct
    When I press the join button
    Then I am registered

  Scenario: Unsuccessful registration: Missing last name
    Given I have entered date of birth "01/01/1990"
    And I have entered first name "Karl"
    And I have entered and confirmed email "mahod47941@rartg.com"
    And I have entered password "Password12345!"
    And I have confirmed password "Password12345!"
    And I have checked terms and conditions
    And I have checked Over 18 and code of conduct
    When I press the join button
    Then I get a message of error that last name is missing

  Scenario: Unsuccessful registration: Password confirmation do not match
    Given I have entered date of birth "01/01/1990"
    And I have entered first name "Karl"
    And I have entered last name "Kalrsson"
    And I have entered and confirmed email "mahodoo4794@rartg.com"
    And I have entered password 'Password12345!'
    And I have confirmed password 'Password!'
    And I have checked terms and conditions
    And I have checked Over 18 and code of conduct
    When I press the join button
    Then I get a message of error that password confirmation do not match

  Scenario: Unsuccessful registration: Terms and conditions are not checked
    Given I have entered date of birth "01/01/1990"
    And I have entered first name "first"
    And I have entered last name "last"
    And I have entered and confirmed email "mail@mail.com"
    And I have entered password "Password12345!"
    And I have confirmed password "Password12345!"
    And I have checked Over 18 and code of conduct
    When I press the join button
    Then I get a message of error that Terms and conditions are not checked
