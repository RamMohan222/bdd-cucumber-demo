package bdd.cucumber.test.execute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import org.testng.TestNG;
import org.testng.collections.Lists;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class CucumberTestNgExecutor {

	public static void main(String[] args) {
		CucumberTestNgExecutor executor = new CucumberTestNgExecutor();
		//executor.run("src/test/resources/suite/testng-cucumber-suite.xml");
		executor.run(2, "src/test/resources/features", "bdd.cucumber.test.hooks", "bdd.cucumber.test.steps");
	}

	void run(String suiteName) {
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add(suiteName);
		testng.setTestSuites(suites);
		testng.run();
	}

	public void run(int threadCount, String feature, String... gluePackages) {
		TestNG testng = new TestNG();
		testng.setXmlSuites(getXmlSuites(threadCount, feature, gluePackages));
		testng.run();
	}

	private List<XmlSuite> getXmlSuites(int threadCount, String features, String... gluePackages) {
		XmlSuite xmlSuite = new XmlSuite();
		xmlSuite.setName("CucumberTestNgSuite");
		xmlSuite.setThreadCount(threadCount);
		xmlSuite.setParallel(XmlSuite.ParallelMode.TESTS);

		XmlTest xmlTest = new XmlTest();
		XmlClass xmlClass = new XmlClass("bdd.cucumber.test.run.TestNgCucumberSuiteRunner");
		xmlClass.setName("TestNgCucumberSuiteRunner");

		List<XmlClass> classes = Lists.newArrayList();
		classes.add(xmlClass);

		StringJoiner joiner = new StringJoiner(",");
		for (String glue : gluePackages) {
			joiner.add(glue);
		}

		long timestamp = System.currentTimeMillis();
		Map<String, String> params = new HashMap<>();
		params.put("cucumber.features", features);
		params.put("cucumber.glue", joiner.toString());
		params.put("cucumber.plugin",
				"pretty,html:target/testng-cucumber-suite-runner-report.html,json:target/cucumber-testng-report.json");

		xmlTest.setName("TestNgCucumberSuiteTest" + timestamp);
		xmlTest.setParameters(params);
		xmlTest.setXmlClasses(classes);
		xmlSuite.addTest(xmlTest);
		xmlTest.setXmlSuite(xmlSuite);

		List<XmlSuite> xmlSuites = Lists.newArrayList();
		xmlSuites.add(xmlSuite);

		return xmlSuites;

	}
}
