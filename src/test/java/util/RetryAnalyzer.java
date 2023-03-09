package util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	int counter = 0;
	int maxTry = 2;
	

	@Override
	public boolean retry(ITestResult result) {
		if(counter < maxTry) {
			counter++;
			return true;
		}
		return false;
	}

}
