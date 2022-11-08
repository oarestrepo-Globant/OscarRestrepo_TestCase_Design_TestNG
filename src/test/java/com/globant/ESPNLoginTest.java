package com.globant;

import org.testng.annotations.Test;

public class ESPNLoginTest extends AppTest{

    @Test
    public void loginUser(){
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
}
