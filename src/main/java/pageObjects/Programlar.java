package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Programlar {


    public WebDriver driver;

    By programList = By.xpath("//div[@class='row program-items']/div");



    /* Constructor */
    public Programlar(WebDriver driver) {
        this.driver = driver;
    }

    /*Methods*/

    public List<WebElement> getProgramList(){
        return driver.findElements(programList);
    }







}
