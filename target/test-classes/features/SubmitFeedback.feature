Feature: Submit feedback - Behavior Driven


  @TC00 @negative
  Scenario: Unsuccessful submit feedback using invalid login email
    Given customer access contact page
    When following fields are entered
      | Field    | Value                         |
      | forename | Zee                           |
      | email    | thisisnotavalidemail          |
      | message  | This message is a failed test |
    Then error in the field is displayed
      | Field     | Message                    |
      | email-err | Please enter a valid email |

  @TC01 @negative
  Scenario: Successful validation of error messages in empty field in submit feedback page
    Given customer access contact page
    When submit button is clicked
    Then error in the field is displayed
      | Field        | Message              |
      | forename-err | Forename is required |
      | email-err    | Email is required    |
      | message-err  | Message is required  |
    When following fields are entered
      | Field    | Value                             |
      | forename | Zee                               |
      | email    | csims@planittesting.com           |
      | message  | This message is a Successful test |
    Then errors will disappear in contact page


  @TC02 @positive @multiple
  Scenario Outline: Successful submission of feedback
    Given customer access contact page
    When customer submits feedback form with the following values
      | Field    | Value      |
      | forename | <forename> |
      | email    | <email>    |
      | message  | <message>  |
    Then it should display that feedback submission is successful for "<forename>"

    Examples:
      | forename | email                   | message         |
      | Zee      | csims@planittesting.com | Message for 1st |
      | Zee      | csims@planittesting.com | Message for 2nd |
      | Zee      | csims@planittesting.com | Message for 3rd |
      | Zee      | csims@planittesting.com | Message for 4th |
      | Zee      | csims@planittesting.com | Message for 5th |