package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int currentRetry = 0;
    private final int maxRetry = 2;   // Retry 2 times

    @Override
    public boolean retry(ITestResult result) {

        if (currentRetry < maxRetry) {

            currentRetry++;

            System.out.println("Retrying Test : "
                    + result.getName()
                    + " | Retry Count : "
                    + currentRetry);

            return true;
        }

        return false;
    }
}