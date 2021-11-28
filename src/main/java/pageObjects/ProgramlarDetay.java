package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProgramlarDetay {


    public WebDriver driver;

    By seriesList = By.xpath("//div[@class='row program-items down-category']/div");
    By durationTime = By.xpath("//div[@class='vjs-duration-display']");
    By publishDate = By.xpath("//div[@class='videoHour']/span");
    By nextList = By.xpath("//div[contains(@class, 'scrollBoxItem')]/div/a");



    /* Constructor */
    public ProgramlarDetay(WebDriver driver) {
        this.driver = driver;
    }

    /*Methods*/

    public List<WebElement> getSeriesList(){
        return driver.findElements(seriesList);
    }

    public String getDurationTime(){

        String inner= driver.findElement(durationTime).getAttribute("innerHTML");
        int index = inner.lastIndexOf(' ');
        return  inner.substring(index+1);

    }

    public String getPublishDate(){
        String inner= driver.findElement(publishDate).getAttribute("innerHTML").trim();
        int index = inner.lastIndexOf(">");
        inner= inner.substring(index+1);
        return inner.trim();
    }

    public List<String> getNextList(){
        List<String> listUrlStr = new ArrayList<>();
        List<WebElement> listUrl = driver.findElements(nextList);

        for(int i=0 ; i<listUrl.size();i++){
            listUrlStr.add(listUrl.get(i).getAttribute("href"));
        }
        return listUrlStr;
    }







}
