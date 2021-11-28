package org.example;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.base;

import java.io.IOException;


public class AppTest 
{

    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException
    {
        //base b1 = new base();
        //driver =b1.initializeDriver();
        driver = new base().initializeDriver();
        //driver.get(b1.getStream().getProperty("url"));
        driver.get(new base().getStream().getProperty("url"));

    }

    @Test
    public void titleC() throws IOException {
        //assertTrue( true );
        System.out.println(driver.getTitle());
    }
}
