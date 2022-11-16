package org.espn.tests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class DeactivateAccountTest extends BaseTest{

    @Test(dataProvider = "credentialsToLogin")
    public void deactivateUserAccountTest(String email, String password) throws InterruptedException {
        home.login(email, password);
        home.deactivate();
        home.login(email, password);
        checkThat("account was deactivated successfully",home.isAccountDeactivated(), Matchers.is(true) );


       /* home.logout();
        checkThat("Welcome message has no username specified", home.getListOfUserNameInNavText(), is(true));*/
    }
}
