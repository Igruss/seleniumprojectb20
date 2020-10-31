package com.cybertek.tests.day2_locators_gettext_getattribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_GoogleTitleVerification {

    public static void main(String[] args) {

        //TC #1: Google Title Verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //2. Go to https://www.google.com ;
         driver.get("https://www.google.com");

        // 3.Verify title:

        //Expected: Google

        String expectedTitle = "Google";
        String actualTile = driver.getTitle();

        if(actualTile.equals(expectedTitle)){
            System.out.println("Title verification PASSED !");
        }else{
            System.out.println("Title verification FAILED!!!");
        }



    }

}
