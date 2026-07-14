package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseTest;
import utils.ExtentReportManager;
import utils.ScreenshotUtility;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentReportManager.getReport();

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {

        System.out.println("Execution Started");

    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());

        test.set(extentTest);

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().log(Status.PASS, "Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().log(Status.FAIL, result.getThrowable());

        try {

            BaseTest base =
                    (BaseTest) result.getInstance();

            ScreenshotUtility screenshot =
                    new ScreenshotUtility(base.driver);

            String path =
                    screenshot.capture(result.getMethod().getMethodName());

            test.get().addScreenCaptureFromPath(path);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().log(Status.SKIP, "Test Skipped");

    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        System.out.println("Execution Finished");

    }

}