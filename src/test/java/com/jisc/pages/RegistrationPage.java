package com.jisc.pages;

import com.jisc.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    public RegistrationPage(){ PageFactory.initElements(Driver.getDriver(),this); }


    @FindBy (id = "name")
    public WebElement nameBox;

    @FindBy (id = "email")
    public WebElement emailBox;

    @FindBy (id = "url")
    public WebElement webAddressBox;

    @FindBy (id = "jobInterests")
    public WebElement interestsBox;

    @FindBy (id = "password")
    public WebElement passwordBox;

    @FindBy (id = "confirmPassword")
    public WebElement confirmPasswordBox;

    @FindBy (xpath = "//button[@class='btn btn-primary']")
    public WebElement registerConfBox;

    @FindBy (xpath = "//div[@class='page-header']")
    public WebElement registerPageHeader;

    @FindBy (xpath = "//p[.='You must provide a valid email address']")
    public WebElement invalidEmailError;

    @FindBy (xpath = "//p[.='You must provide a valid web address']")
    public WebElement invalidWebAddressError;

    @FindBy (xpath = "//p[.='You must provide at least one job interest.']")
    public WebElement invalidInterestError;

    @FindBy (xpath = "//p[.='Your password must be longer than 8 characters']")
    public WebElement invalidPasswordError;

    @FindBy (xpath = "  //p[.='Your passwords did not match']")
    public WebElement passwordsDontMatchError;






    public void openRegistrationPage(){
        HomePage HomePage = new HomePage();
        HomePage.openHomePage();
        HomePage.registerBtn.click();
    }
}
