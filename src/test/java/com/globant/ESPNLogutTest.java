package com.globant;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ESPNLogutTest extends AppTest {
    @BeforeMethod
    public void login(){
        log.info("Pararse en el avatar del navBar");
        log.info("Dar click en Login");
        log.info("En el popup de Login ingresar userName");
        log.info("En el popup de Login ingresar password");
        log.info("Dar click en Login");
    }

    @Test
    public void logoutUser(){
        log.info("Pararse en el avatar del navBar");
        log.info("Dar click en Logout");
        System.out.println("LOGOUT SUCCESS");
    }
}
