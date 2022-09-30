package bdd.cucumber.demo;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features" }, glue = { "bdd.cucumber.demo" }, plugin = { "pretty",
		"html:cucumber-report.html" })
public class JUnitCucumberRunner {

}
