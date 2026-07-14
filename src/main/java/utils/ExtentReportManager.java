package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReportManager {

    private static ExtentReports extent;

    private ExtentReportManager() {
    }

    public static ExtentReports getReport() {

        if (extent == null) {

            createReport();

        }

        return extent;

    }

    private static void createReport() {

        String timestamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss")
                        .format(new Date());

        String reportFolder =
                System.getProperty("user.dir")
                        + File.separator
                        + "reports";

        new File(reportFolder).mkdirs();

        String reportPath =
                reportFolder
                        + File.separator
                        + "AutomationReport_"
                        + timestamp
                        + ".html";

        ExtentSparkReporter spark =
                new ExtentSparkReporter(reportPath);

        spark.config().setDocumentTitle("Automation Report");

        spark.config().setReportName("Selenium Automation Report");

        extent = new ExtentReports();

        extent.attachReporter(spark);

        extent.setSystemInfo("Framework", "Selenium Java");

        extent.setSystemInfo("Tester", "Chirag Panchal");

        extent.setSystemInfo("Browser", ConfigReader.getBrowser());

    }

    public static void flushReport() {

        if (extent != null) {

            extent.flush();

        }

    }

}