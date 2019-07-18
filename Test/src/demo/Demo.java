package demo;

import org.testng.annotations.Test;

public class Demo {
	@Test(priority=0,groups="Regression")
	public void testCaseOne()
	{
	System.out.println("Im in testCaseOne - And in Regression Group");
	}
	@Test(priority=1,groups="Regression")
	public void testCaseTwo(){
	System.out.println("Im in testCaseTwo - And in Regression Group");
	}
	@Test(priority=3,groups="Smoke")
	public void testCaseThree(){
	System.out.println("Im in testCaseThree - And in Smoke Test Group");
	}
	@Test(priority=2,groups="Regression")
	public void testCaseFour(){
	System.out.println("Im in testCaseFour - And in Regression Group");
	}
}
