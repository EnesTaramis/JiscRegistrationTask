package com.jisc.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/jisc/step_definitions",
        features = "@target/retun.txt"

)
public class FailedTestRunner {


}
