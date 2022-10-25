package bdd.cucumber.test.run;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// This class will be executed through testng suite executor
// @formatter:off
// these properties can be over write from suite.xml file
@CucumberOptions(
		features = { "src/test/resources/features" }, 
		glue = { "bdd.cucumber.demo" }, 
		plugin = { "pretty","html:build/cucumber-testng-suite-runner-report.html" })
// @formatter:on
public class TestNgCucumberSuiteRunner extends AbstractTestNGCucumberTests {
	
	public TestNgCucumberSuiteRunner() {
		System.out.println("TestNgCucumberSuiteRunner execution started...");
	}

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
