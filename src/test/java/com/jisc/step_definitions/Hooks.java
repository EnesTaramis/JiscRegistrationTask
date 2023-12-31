package com.jisc.step_definitions;

import com.jisc.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    //this method allows us to take screenshots of our failed step definitions and attach it to our cucumber report
    @After
    public static void tearDownSs(Scenario scenario){

        if (scenario.isFailed()){

            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }
    }

    //closing our driver instance after our tests finsih running
    @AfterAll
    public static void tearDown(){
        Driver.getDriver().close();
    }
}
