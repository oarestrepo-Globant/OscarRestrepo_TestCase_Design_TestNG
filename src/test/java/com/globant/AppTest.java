package com.globant;

import org.testng.annotations.*;

import java.util.logging.Logger;

// https://www.espnqa.com/?_adbock=true&src=com
public class AppTest {
    public static final Logger log = Logger.getLogger(String.valueOf(AppTest.class));

    @BeforeSuite
    public void getCredentials(){
        log.info("Tener una cuenta valida en www.espnqa.com");
        System.out.println();
    }

    @BeforeTest
    public void openBrowser(){
        log.info("Abrir el/los navegadores");
        log.info("Comprobar que el navegador se abrio");
        System.out.println();
    }

    @BeforeClass
    public void openWebPage(){
        log.info("Ingresar a la pagina web https://www.espnqa.com/?_adbock=true&src=com");
        log.info("Comprobar que estoy en la pagina https://www.espnqa.com/?_adbock=true&src=com");
        System.out.println();
    }

    @AfterTest
    public void closeBrowser(){
        log.info("Cerrar el/los navegadores");
        log.info("Comprobar que el navegador se cerro");
        System.out.println();
    }
}
