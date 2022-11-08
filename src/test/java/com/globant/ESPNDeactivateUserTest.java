package com.globant;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ESPNDeactivateUserTest extends AppTest{
    @BeforeMethod
    public void login(){
        log.info("Pararse en el avatar del navBar");
        log.info("Dar click en Login");
        log.info("En el popup de Login ingresar userName");
        log.info("En el popup de Login ingresar password");
        log.info("Dar click en Login");
    }

    @Test
    public void deactivateUser(){
        log.info("Pararse en el avatar del navBar");
        log.info("Dar click en ESPN Profile");
        log.info("En el popup: Hacer scroll hasta abajo");
        log.info("Dar click en Delete Account");
        log.info("Dar click en el boton 'Yes, delete this account'");
        log.info("Dar click en 'OK'");
        System.out.println();
    }
}
