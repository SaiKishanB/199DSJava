package com.mph.testcase;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunnerClass {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestClass.class);
		for(Failure f : result.getFailures())
		{
			System.out.println(f);
		}
		System.out.println("Sucess ? " + result.wasSuccessful());
		
	}

}