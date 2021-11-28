package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pageObjects.Programlar;
import pageObjects.ProgramlarDetay;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class vavTv {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","//Users//tarikbozyak//selenium//chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.vavtv.com.tr");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;


        //header'da ki elemanlar listeye eklendi.
        //0 -> Canlı Yayın
        //1 -> Programlar
        //2 -> Kuran-ı Kerim
        //3 -> Yayın Akışı
        //4 -> Frekanslar
        List<WebElement> headerList = driver.findElements(By.xpath("//ul[@class='d-flex align-items-center']/li"));
        headerList.get(1).click();
        Thread.sleep(1000L);


        String mainPage = driver.getWindowHandle();
        System.out.println(mainPage);
        System.out.println("main : "+mainPage);

        //Programlar listesi listede tutulur.

        //List<WebElement> programlarList = driver.findElements(By.xpath("//div[@class='row program-items']/div"));
        //programlarList.get(0).click();

        Programlar p1 = new Programlar(driver);
        p1.getProgramList().get(0).click();

        Thread.sleep(1000L);

        System.out.println(driver.getTitle());


        for(String winHandle : driver.getWindowHandles()){

            if(!winHandle.equals(mainPage)) {
                driver.switchTo().window(winHandle);
            }
        }

        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(1000L);
        action.sendKeys(Keys.PAGE_UP).build().perform();
        Thread.sleep(1000L);
        ProgramlarDetay p2 = new ProgramlarDetay(driver);

        System.out.println("liste uzunluğu : "+p2.getSeriesList().size());
        int c=1;
        int seriesListSize= p2.getSeriesList().size();
        for(int i=0; i<(seriesListSize);i++){


            if(i>14){
                Thread.sleep(1000L);
                js.executeScript("arguments[0].scrollIntoView();", p2.getSeriesList().get(i));
                //Thread.sleep(1000L);
            }
            p2.getSeriesList().get(i).click();
            Thread.sleep(2000L);
            System.out.println("***Sıra no : "+c);
            System.out.println(driver.getTitle());
            System.out.println(p2.getDurationTime());
            System.out.println(p2.getPublishDate());
            System.out.println("Sıradaki liste eleman sayısı : "+p2.getNextList().size() +"--- örn :"+p2.getNextList().get(1));
            driver.navigate().back();
            c++;

        }









    }
}
