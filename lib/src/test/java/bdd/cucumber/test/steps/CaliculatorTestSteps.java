package bdd.cucumber.test.steps;

import static org.junit.Assert.assertEquals;

import bdd.cucumber.test.demo.Calculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CaliculatorTestSteps {

	private Calculator calculator = null;
	private int output = 0;

	@Given("Create a calculator")
	public void createCalculator() {
		calculator = new Calculator(0);
	}

	@When("I call a add operation with {int} and {int}")
	public void add(int a, int b) {
		output = calculator.add(a, b);
	}

	@Then("I get result as {int}")
	public void result(int c) {
		assertEquals(c, output);
	}
}
