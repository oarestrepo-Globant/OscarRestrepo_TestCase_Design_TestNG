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
        //validaciones solo se hacen en test
        log.info("Verificar si el login fue satisfactorio");
        System.out.println("LOGIN SUCCESS");
    }
}
