package bdd.cucumber.test.execute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CucumberTestExecutor {

	private static String FEATURE_LOCATION = "src/test/resources/features/";

	public static void main(String[] args) {
		run(null);
	}

	static void run(String feature, String... gluePackages) {
		//@formatter:off
		String[] initOptions = new String[] { 
				"--threads", "2", 
				"--plugin", "pretty", 
				"--plugin", "html:target/cucumber-executor-report.html", 
				//"--plugin", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", 
				"--glue", "bdd.cucumber.test.hooks", 
				"--glue", "bdd.cucumber.test.steps"};
		// @formatter:on

		List<String> argOptions = new ArrayList<>(Arrays.asList(initOptions));
		for (String glue : gluePackages) {
			argOptions.add("--glue");
			argOptions.add(glue);
		}

		if (Objects.isNull(feature)) {
			// executes all features
			argOptions.add(FEATURE_LOCATION);
		} else {
			// executes specific feature
			argOptions.add(FEATURE_LOCATION + feature);
		}

		String[] optionsAry = argOptions.toArray(new String[] {});

		io.cucumber.core.cli.Main.run(optionsAry, Thread.currentThread().getContextClassLoader());
	}
}
