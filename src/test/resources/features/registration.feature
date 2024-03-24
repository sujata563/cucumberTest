Feature:

  Scenario: Sucessful registration
    Given Navigate to basketball page
    Given I have entered date of birth "19/03/2000"
    Given Enter first name "Suzi"
    Given Enter last name "Cha"
    Given Enter email "suzicha124@gmail.com"
    Given  Repeat email "suzicha124@gmail.com"
    Given Enter password "abcdEF"
    Given Repeat password "abcdEF"
    Given Click terms and condition
    Given Click in over 18
    And Click in code of ehics
    When Click on registrationbutton
    Then Verify "Basketball England Members Area" on side

  Scenario: UnSucessful registration - last name missing
    Given Navigate to basketball page
    Given I have entered date of birth "19/03/2000"
    Given Enter first name "Suzi"
    Given Enter email "suzicha123@gmail.com"
    Given  Repeat email "suzicha123@gmail.com"
    Given Enter password "abcdEF"
    Given Repeat password "abcdEF"
    Given Click terms and condition
    Given Click in over 18
    And Click in code of ehics
    When Click on registrationbutton
    Then Verify fail message "Last Name is required" on side

  Scenario: UnSucessful registration -  password doesn't match
    Given Navigate to basketball page
    Given I have entered date of birth "19/03/2000"
    Given Enter first name "Suzi"
    Given Enter email "suzicha123@gmail.com"
    Given  Repeat email "suzicha123@gmail.com"
    Given Enter password "abcdEF"
    Given Repeat password "abcdEFGH"
    Given Click terms and condition
    Given Click in over 18
    And Click in code of ehics
    When Click on registrationbutton
    Then Verify fail password message "Password did not match" on side

  Scenario: UnSucessful registration -  Terms and condition are not accepted
    Given Navigate to basketball page
    Given I have entered date of birth "19/03/2000"
    Given Enter first name "Suzi"
    Given Enter last name "Cha"
    Given Enter email "suzicha123@gmail.com"
    Given  Repeat email "suzicha123@gmail.com"
    Given Enter password "abcdEF"
    Given Repeat password "abcdEF"
    Given Click in over 18
    And Click in code of ehics
    When Click on registrationbutton
    Then Verify fail TaC message "You must confirm that you have read and accepted our Terms and Conditions" on side