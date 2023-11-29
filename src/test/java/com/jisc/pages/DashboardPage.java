package com.jisc.pages;

import com.jisc.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage(){ PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy (xpath = "//h2[@class='ng-binding']")
    public WebElement greetingMessage;

    @FindBy (xpath = "//div[@class='alert alert-success']")
    public WebElement regSuccessMessage;


    @FindBy (xpath = "(//a[@class='ng-binding'])[1]")
    public WebElement jobVacancy1;

    @FindBy (xpath = "(//a[@class='ng-binding'])[2]")
    public WebElement jobVacancy2;

    @FindBy (xpath = "(//a[@class='ng-binding'])[3]")
    public WebElement jobVacancy3;

    @FindBy (xpath = "(//a[@class='ng-binding'])[4]")
    public WebElement jobVacancy4;

    @FindBy (xpath = "(//a[@class='ng-binding'])[5]")
    public WebElement jobVacancy5;

}
