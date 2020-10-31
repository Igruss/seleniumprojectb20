package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

          driver.manage().window().maximize();

        driver.get("https://www.google.com");
/*
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver1 = new FirefoxDriver();

        driver1.get("https://www.google.com");
*/

        System.out.println("The title of the page is: "+driver.getTitle());

        String actualUrl = driver.getCurrentUrl();
    

        System.out.println("actualUrl = " + actualUrl);

        Thread.sleep(2000);
        driver.navigate().refresh();

        String pageSource = driver.getPageSource();

        System.out.println("pageSource = " + pageSource);

        driver.close();

        driver.quit();





    }

}
