package org.espn.tests;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class DeactivateAccountTest extends BaseTest{

    @Test(dataProvider = "credentialsToLogin")
    public void deactivateUserAccountTest(String email, String password) throws InterruptedException {
        home.login(email, password);
        home.deactivate();
        home.login(email, password);
        checkThat("account was deactivated successfully",home.isAccountDeactivated(),is( true) );
    }
}
