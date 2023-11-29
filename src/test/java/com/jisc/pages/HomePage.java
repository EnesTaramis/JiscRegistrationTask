package com.jisc.pages;

import com.jisc.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class HomePage {

    public HomePage(){ PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath = "//a[@class='btn btn-primary btn-lg']")
    public WebElement registerBtn;

    public void openHomePage(){

        File regFile = new File("registration-test/index.html");
        String regPath = regFile.getAbsolutePath();
        Driver.getDriver().get("file://" + regPath);
    }

}
