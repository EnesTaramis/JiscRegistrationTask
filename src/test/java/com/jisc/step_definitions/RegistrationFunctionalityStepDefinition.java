package com.jisc.step_definitions;

import com.github.javafaker.Faker;
import com.jisc.pages.DashboardPage;
import com.jisc.pages.HomePage;
import com.jisc.pages.RegistrationPage;
import com.jisc.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationFunctionalityStepDefinition {

    HomePage HomePage = new HomePage();
    RegistrationPage RegistrationPage = new RegistrationPage();
    DashboardPage DashboardPage = new DashboardPage();


    @Given("the student is on the homepage")
    public void the_student_is_on_the_homepage() {

        HomePage.openHomePage();

    }
    @When("the student clicks on the registration link")
    public void the_student_clicks_on_the_registration_link() {

        HomePage.registerBtn.click();
    }
    @Then("the student should be taken to the registration page")
    public void the_student_should_be_taken_to_the_registration_page() {

        Assert.assertTrue(RegistrationPage.registerPageHeader.isDisplayed());
    }

    @Given("the student is on the registration page")
    public void theStudentIsOnTheRegistrationPage() {
        RegistrationPage.openRegistrationPage();
    }


    Faker faker = new Faker(); // we are going to generate some personal information using Java Faker.
    String name = faker.name().fullName();
    String email = faker.internet().emailAddress();
    String webAddress = faker.internet().url();
    String jobInterests = faker.job().field();
    String password = faker.internet().password(9,20,true,true);

    @When("the student enters valid first name, email address, password, password confirmation and interests")
    public void theStudentEntersValidFirstNameEmailAddressPasswordPasswordConfirmationAndInterests() {

        RegistrationPage.nameBox.sendKeys(name);
        RegistrationPage.emailBox.sendKeys(email);
        RegistrationPage.webAddressBox.sendKeys(webAddress);

        Driver.getDriver().switchTo().frame("iframe");
        RegistrationPage.interestsBox.sendKeys(jobInterests);
        Driver.getDriver().switchTo().parentFrame();

        RegistrationPage.passwordBox.sendKeys(password);
        Assert.assertTrue(password.length()>=8);
        RegistrationPage.confirmPasswordBox.sendKeys(password);


    }

    @Then("the student is able to register successfully")
    public void theStudentIsAbleToRegisterSuccessfully() {

        RegistrationPage.registerConfBox.click();
        Assert.assertTrue(DashboardPage.regSuccessMessage.isDisplayed());

    }

    @And("is met with a personalised greeting message on the dashboard")
    public void isMetWithAPersonalisedGreetingMessageOnTheDashboard() {

        Assert.assertTrue(DashboardPage.greetingMessage.isDisplayed());
        Assert.assertTrue(DashboardPage.greetingMessage.getText().contains(name));
    }

    @And("five job vacancies are visible on the dashboard")
    public void fiveJobVacanciesAreVisibleOnTheDashboard() {

        Assert.assertTrue(DashboardPage.jobVacancy1.isDisplayed());
        Assert.assertTrue(DashboardPage.jobVacancy2.isDisplayed());
        Assert.assertTrue(DashboardPage.jobVacancy3.isDisplayed());
        Assert.assertTrue(DashboardPage.jobVacancy4.isDisplayed());
        Assert.assertTrue(DashboardPage.jobVacancy5.isDisplayed());
    }


    @Given("the student is on the registration page and has filed in everything correctly except password and password confirmation")
    public void theStudentIsOnTheRegistrationPageAndHasFiledInEverythingCorrectlyExceptPasswordAndPasswordConfirmation() {

        RegistrationPage.openRegistrationPage();
        RegistrationPage.nameBox.sendKeys(name);
        RegistrationPage.emailBox.sendKeys(email);
        RegistrationPage.webAddressBox.sendKeys(webAddress);

        Driver.getDriver().switchTo().frame("iframe");
        RegistrationPage.interestsBox.sendKeys(jobInterests);
        Driver.getDriver().switchTo().parentFrame();

    }


    @When("the student enters a valid password \\(containing at least eight characters) and enters the same password in the password confirmation box")
    public void theStudentEntersAValidPasswordContainingAtLeastEightCharactersAndEntersTheSamePasswordInThePasswordConfirmationBox() {

        RegistrationPage.passwordBox.sendKeys(password);
        RegistrationPage.confirmPasswordBox.sendKeys(password);

        String initialPassEntry = RegistrationPage.passwordBox.getAttribute("value");  //getting the value stored in "value" attribute - this is what we entered into password box
        String passwordConfirmation = RegistrationPage.confirmPasswordBox.getAttribute("value"); //this is what we entered into password confirmation box

        Assert.assertEquals(initialPassEntry,passwordConfirmation); //this assertion will make sure both our password entries match.
        Assert.assertTrue(password.length()>=8);
    }

    @Then("the student can successfully register when they click the Register button and get directed to the dashboard")
    public void theStudentCanSuccessfullyRegisterWhenTheyClickTheRegisterButtonAndGetDirectedToTheDashboard() {

        RegistrationPage.registerConfBox.click();
        Assert.assertTrue(DashboardPage.greetingMessage.isDisplayed());
    }


    @When("the student enters any invalid entries for either {string}, {string}, interests \\(empty field), {string}, {string}")
    public void theStudentEntersAnyInvalidEntriesForEitherInterestsEmptyField(String emailAddress, String webAddress, String password, String passwordConf) {

        RegistrationPage.nameBox.sendKeys(name);
        RegistrationPage.emailBox.sendKeys(emailAddress);
        RegistrationPage.webAddressBox.sendKeys(webAddress);
        RegistrationPage.passwordBox.sendKeys(password);
        RegistrationPage.confirmPasswordBox.sendKeys(passwordConf);

        RegistrationPage.registerConfBox.click();
    }

    // WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Then("the student is met with an appropriate validation error message depending on the invalid entry")
    public void theStudentIsMetWithAnAppropriateValidationErrorMessageDependingOnTheInvalidEntry() {


        if (RegistrationPage.emailBox.getAttribute("value").equals("invalid email")){
            System.out.println("1.if triggered");
            Assert.assertTrue(RegistrationPage.invalidWebAddressError.isDisplayed());
            Assert.assertTrue(RegistrationPage.invalidPasswordError.isDisplayed());
            Assert.assertTrue(RegistrationPage.invalidEmailError.isDisplayed());

        }


        if (RegistrationPage.passwordBox.getAttribute("value").equals("validpass")){
            System.out.println("2.if triggered");
            Assert.assertTrue(!RegistrationPage.passwordBox.getAttribute("value").equals(RegistrationPage.confirmPasswordBox.getAttribute("value")));
            Assert.assertTrue(RegistrationPage.passwordsDontMatchError.isDisplayed());
        }
    }



}
