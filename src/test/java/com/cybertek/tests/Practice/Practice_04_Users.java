package com.cybertek.tests.Practice;

import com.cybertek.utilites.BrowserUtils;
import com.cybertek.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Practice_04_Users {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://library2.cybertekschool.com/login.html");
    }

    @Test
    public void students() {

        WebElement email= driver.findElement(By.xpath("//input[@id='inputEmail']"));
        email.sendKeys("librarian47@library");

        WebElement password = driver.findElement(By.xpath("//input[@id='inputPassword']"));
        password.sendKeys("rJEIrUIt");

        BrowserUtils.wait(3);
        WebElement signIn = driver.findElement(By.xpath("//button"));
        signIn.click();

        BrowserUtils.wait(3);
        WebElement users = driver.findElement(By.xpath("//*[@id=\"menu_item\"]/li[2]/a/span[1]"));
        users.click();

        BrowserUtils.wait(3);

        WebElement students = driver.findElement(By.xpath("//*[@id=\"user_groups\"]/option[3]"));
        students.click();


    }

}