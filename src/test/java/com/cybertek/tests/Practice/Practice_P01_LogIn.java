package com.cybertek.tests.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_P01_LogIn {

    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://qa2.vytrack.com/user/login");

        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.findElement(By.name("_username")).sendKeys("User165");
        Thread.sleep(2000);

        driver.findElement(By.name("_password")).sendKeys("UserUser123"+ Keys.ENTER);

       Thread.sleep(2000);

       String expectedResult = "Dashboard";

       String actualResult = driver.getTitle();

        System.out.println("expectedTitle = " + expectedResult);
        System.out.println("actualTitle = " + actualResult);

        if (expectedResult.equals(actualResult)){
            System.out.println("Title verification pass!");
        }else{
            System.out.println("Title verification failed!");
        }
        Thread.sleep(2000);
        driver.close();

    }



    }


