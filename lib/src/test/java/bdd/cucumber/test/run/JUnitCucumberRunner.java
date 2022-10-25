package bdd.cucumber.test.run;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/*
 * This class executed by JUnit runner
 */
// @formatter:off
@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/resources/features" }, 
		glue = { "bdd.cucumber.test.hooks", "bdd.cucumber.test.steps" }, 
		plugin = { "pretty","html:build/cucumber-junit-runner-report.html" })
public class JUnitCucumberRunner {
	
}
// @formatter:on
