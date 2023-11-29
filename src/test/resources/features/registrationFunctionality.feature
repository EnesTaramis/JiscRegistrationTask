Feature: A student can register with our website to receive job vacancies, to help them find a job.

  Description:
  As a student
  I want to securely register & access the student dashboard
  So that I am able see the Dashboard Page with a personalised greeting and a list of job vacancies

  Acceptance criteria:
  Student can access the registration page via a link from the home page.
  Student can register using name, email address, web address, job interests, password and password confirmation.
  After registering, a personalised greeting message and five job vacancies will be visible on the dashboard.
  Student must use a valid email address when registering.
  Password and Confirm password entries must match.
  Password should contain at least 8 characters.
  If any validation error occurs, then an appropriate message will be displayed to the user.

  @smoke
  Scenario: Student should be able to access the registration page from the homepage by clicking the ‘Create an Account’ button.
    Given the student is on the homepage
    When the student clicks on the registration link
    Then the student should be taken to the registration page


  Scenario: After successful registration with valid credentials, the customer is met with a personalised greeting message on the dashboard. Five job vacancies will be visible on the dashboard.
    Given the student is on the registration page
    When the student enters valid first name, email address, password, password confirmation and interests
    Then the student is able to register successfully
    And is met with a personalised greeting message on the dashboard
    And five job vacancies are visible on the dashboard


  @smoke
  Scenario: For successful registration, password & confirm password entries need to match and be a valid password (at least 8 characters).
    Given the student is on the registration page and has filed in everything correctly except password and password confirmation
    When the student enters a valid password (containing at least eight characters) and enters the same password in the password confirmation box
    Then the student can successfully register when they click the Register button and get directed to the dashboard


  @NegativeScenario @smoke
  Scenario Outline: When an invalid entry is entered into either email address, web address, password or password confirmation, an appropriate validation error message is displayed
    Given the student is on the registration page
    When the student enters any invalid entries for either "<email address>", "<web address>", interests (empty field), "<password>", "<password confirmation>"
    Then the student is met with an appropriate validation error message depending on the invalid entry
    Examples:
      | email address        | web address             | password  | password confirmation |
      | invalid email        | invalid web address     | badpass   | badpass               |
      | validemail@gmail.com | www.validwebaddress.com | validpass | nonmatchingpass       |

    #first test gives errors for invalid email, web address & password
    #second test gives error for non matching password confirmation
    #invalid interests is not included here as i hava found a bug where if we enter anything into the interests box, it allows us to register even if other fields are entered incorrectly

