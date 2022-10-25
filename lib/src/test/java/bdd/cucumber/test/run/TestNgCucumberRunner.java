package bdd.cucumber.test.run;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

// This will be executed with testng cucumber runner.
// @formatter:off
@CucumberOptions(
		features = { "src/test/resources/features" }, 
		glue = { "bdd.cucumber.test.hooks", "bdd.cucumber.test.steps"}, 
		plugin = { "pretty","html:build/cucumber-testng-runner-report.html" })
// @formatter:on
public class TestNgCucumberRunner {

	private TestNGCucumberRunner testNgCucumberRunner = null;

	@BeforeClass
	public void setUp() {
		testNgCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(dataProvider = "features")
	public void test(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
		testNgCucumberRunner.runScenario(pickleWrapper.getPickle());
	}

	@DataProvider
	public Object[][] features() {
		return testNgCucumberRunner.provideScenarios();
	}

	@AfterClass
	public void tearDown() {
		testNgCucumberRunner.finish();
	}
}
