package org.example;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.base;

import java.io.IOException;

public class indexTest {

    public WebDriver driver;

    @BeforeTest
    public void initializer() throws IOException {
        base b1 = new base();
        driver = b1.initializeDriver();
        driver.get(b1.getStream().getProperty("url"));
    }

    @Test
    public void title(){
        System.out.println(driver.getTitle());
        System.out.println("title : "+driver.getTitle());
    }
}
