package org.espn.utils;

import org.espn.reporting.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result){
        Logger.info("Test: " + result.getName() + " [PASSED]");
    }

    @Override
    public void onTestFailure(ITestResult result){
        Logger.error("Test: " + result + " [FAILED]");
    }
}
