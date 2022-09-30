package bdd.cucumber.demo.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class BddHooks {

	@Before
	public void before() {
		System.out.println(">> Before");
	}

	@BeforeAll
	public static void beforeAll() {
		System.out.println(">> Before All");
	}

	@After
	public void after() {
		System.out.println(">> After");
	}

	@AfterAll
	public static void afterAll() {
		System.out.println(">> After All");
	}
}
