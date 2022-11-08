package com.globant;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ESPNWebListeners implements ITestListener {
    @Override
    public void onStart(ITestContext arg0){
        System.out.println("TEST STARTED");
        System.out.println();
    }

    @Override
    public void onFinish(ITestContext arg0){
        System.out.println("TEST COMPLETED");
        System.out.println();
    }

    @Override
    public void onTestFailure(ITestResult arg0){
        System.out.println("TEST FAILED");
        System.out.println();
    }

    @Override
    public void onTestSuccess(ITestResult arg0){
        System.out.println("TEST PASSED");
        System.out.println();
    }
}
