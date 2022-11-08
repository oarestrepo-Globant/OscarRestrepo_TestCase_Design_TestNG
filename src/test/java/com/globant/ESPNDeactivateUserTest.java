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
        log.info("Pararse en el avatar del navBar");
        log.info("Verificar si en la columna izquierda del pop up aparece !Bienvenido userName!");
        log.info("Verificar si en la columna izquierda del pop up esta la opcion de logout");
        log.info("Verificar si en la columna izquierda del pop up esta la opcion de ESP profile");
        System.out.println();
    }

    @Test
    public void deactivateUser(){
        log.info("Pararse en el avatar del navBar");
        log.info("Dar click en ESPN Profile");
        log.info("En el popup: Hacer scroll hasta abajo");
        log.info("Dar click en Delete Account");
        log.info("Dar click en el boton 'Yes, delete this account'");
        log.info("Dar click en 'OK'");
        login();
        System.out.println();
    }
}
