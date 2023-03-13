package testing;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import util.BaseClass;
import util.CommonMethods;
import util.ListenersTestNG;
import util.RetryAnalyzer;
@Listeners(ListenersTestNG.class)
public class LoginTest extends CommonMethods{
	
	
	@Test(enabled = true, retryAnalyzer = RetryAnalyzer.class, groups = "smoke")
	public void test1() {
		BaseClass.getDriver().findElement(By.xpath("dsawda")).click();
	}
	
	public void test2() {
		System.out.println("hi");
	}

}
