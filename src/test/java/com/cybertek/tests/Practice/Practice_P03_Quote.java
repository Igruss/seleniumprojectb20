package com.cybertek.tests.Practice;

import com.cybertek.utilites.BrowserUtils;
import com.cybertek.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Practice_P03_Quote {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://login2.nextbasecrm.com/stream/");

    }

    @Test
    public void logIn() {

        WebElement userName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userName.sendKeys("helpdesk15@cybertekschool.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");

        WebElement logIn = driver.findElement(By.xpath("//input[@value='Log In']"));
        logIn.click();

        WebElement task = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']"));
        task.click();

        //  WebElement addMentionIcon = driver.findElement(By.xpath("//div[@class='feed-add-post-form-but-wrap']/span[5]"));
        WebElement commaIcon = driver.findElement(By.xpath("(//span[@title='Quote text'])[2]"));
        commaIcon.click();

        WebElement iframe = driver.findElement(By.xpath("(//iframe[@class='bx-editor-iframe'])[2]"));

        driver.switchTo().frame(iframe);
        BrowserUtils.wait(2);

        WebElement typeQuota = driver.findElement(By.className("bxhtmled-quote"));
        typeQuota.sendKeys("Hello Cybertek");
        BrowserUtils.wait(2);

        driver.switchTo().parentFrame();

        BrowserUtils.wait(2);
        //It clicks the send button
        WebElement sendButton = driver.findElement(By.xpath("(//button[@class='ui-btn ui-btn-lg ui-btn-primary'])[1]"));
        sendButton.click();
    }
}




