package com.cybertek.tests.day2_locators_gettext_getattribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_CybertekURLVerification {

    public static void main(String[] args) {


        //TC #2: Cybertek verifications
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //2. Go to http://practice.cybertekschool.com
        driver.get("http://practice.cybertekschool.com");
        //3. Verify URL contains
        //Expected: cybertekschool
        String expectedURL = "cybertekschool";
        String actualURL = driver.getCurrentUrl();

        if(actualURL.contains(expectedURL)){
            System.out.println("URL Verification PASSED!");
        }else{
            System.out.println("URL Verification FAILED!!!");
        }
        //4. Verify title:
        //Expected: Practice

        if(driver.getTitle().equals("Practice")){
            System.out.println("Title Verification PASSED!");
        }else{
            System.out.println("Title Verification FAILED!!!");
        }






    }

}
