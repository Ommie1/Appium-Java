package org.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
    static ExtentReports extent;

    public static ExtentReports getReportObject(){
        String path = System.getProperty("user.dir")+"\\Test-Report\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Mobile Test Automation");
        reporter.config().setDocumentTitle("Automation Results");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Syed Umair Hassan");
        return extent;
    }
}
