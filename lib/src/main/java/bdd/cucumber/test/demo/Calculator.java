package bdd.cucumber.test.demo;

public class Calculator {
	private int init = 0;

	public Calculator(int init) {
		this.init = init;
	}

	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public int getInit() {
		return this.init;
	}
}
