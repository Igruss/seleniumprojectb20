package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
TC #4: Iframe practice1.Create a new class called: IframePractice
2.Create new test and make set ups
3.Go to: http://practice.cybertekschool.com/iframe
4.Assert: “Your content goes here.” Text is displayed.
5.Assert: “An iFrame containing the TinyMCEWYSIWYG Editor
 */
public class IframePractice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/iframe");

    }

    @Test
    public void p4_iframe_practice(){

        //3 ways of loc
        //1.= ByIndex
     //   driver.switchTo().frame(0);

        //2.= By ID or Name
      //  driver.switchTo().frame("mce_0_ifr");

        //3. As a web element,than switch to it
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        //Locating paragraph tag as a web element
        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));

        // Assert text is displayed on the page
        Assert.assertTrue(yourContentGoesHereText.isDisplayed(),"Text is not displayed.Verificatiob FAILED!!!");

        //Assert iframe containing the TinyMCEWYSIWYG Editor
        driver.switchTo().defaultContent();
        //driver.switchTo().parentFrame();

        WebElement headerText = driver.findElement(By.xpath("//h3"));

        Assert.assertTrue(headerText.isDisplayed(),"Header text is not displayed.Verification FAILED!!!");



    }


}
