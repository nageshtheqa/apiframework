package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/addplaceValidations.feature",
glue = "stepDefinations",
tags = "@pvtenum",
stepNotifications  = true)
public class TestRunner {

}
