package com.cybertek.tests.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_P02_ViewOption {


    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://qa2.vytrack.com/user/login");

        driver.manage().window().maximize();
        Thread.sleep(1000);

        driver.findElement(By.name("_username")).sendKeys("User165");
        Thread.sleep(1000);

        driver.findElement(By.name("_password")).sendKeys("UserUser123" + Keys.ENTER);

        Thread.sleep(1000);

        WebElement fleetModule = driver.findElement(By.linkText("Fleet"));
        fleetModule.click();
        Thread.sleep(1000);

        WebElement vehicleModule = driver.findElement(By.xpath("//span[.='Vehicles']"));
        vehicleModule.click();
        Thread.sleep(1000);

        WebElement viewModule = driver.findElement(By.xpath("//li[@class='launcher-item']"));
        Thread.sleep(1000);
         viewModule.click();


    }
}