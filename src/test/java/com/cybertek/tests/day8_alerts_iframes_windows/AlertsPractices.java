package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.utilites.BrowserUtils;
import com.cybertek.utilites.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
/*
TC #1: Information alert practice1.Open browser
2.Go to website: http://practice.cybertekschool.com/javascript_alerts
3.Click to “Click for JS Alert”button
4.Click to OK button from the alert
5.Verify “You successfulyclicked an alert”text is displayed.
 */
public class AlertsPractices {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

    }

    @Test
    public void p1_information_alert_practice(){

        WebElement warningAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));

        BrowserUtils.wait(2);

        warningAlertButton.click();

        Alert alert = driver.switchTo().alert();

        BrowserUtils.wait(2);

        alert.accept();

        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));


        //assert "resultText" is displayed
        Assert.assertTrue(resultText.isDisplayed(), "Result text is not displayed. Verification failed!!!");

    }

    @Test

    public void p2_confirmation_alert_practice(){
        //Locating the warning/information alert button to click it
        WebElement warningAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));

        BrowserUtils.wait(2);
        //click to the button
        warningAlertButton.click();

        Alert alert = driver.switchTo().alert();

        alert.accept();

        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));


        //assert "resultText" is displayed
        Assert.assertTrue(resultText.isDisplayed(), " Text is not displayed. Verification failed!!!");

    }



    }




