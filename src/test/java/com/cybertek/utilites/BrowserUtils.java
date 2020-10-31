package com.cybertek.utilites;
//Storing utility methods for any browser,or for any useful  method for the future

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class BrowserUtils {

    /**
    Accepts a list of Web Element
    @param list
    @return List<String>
     Method should return list os String
     */

    public static List<String> getElementsText(List<WebElement> list){

        List<String> webelementsAsString = new ArrayList<>();

        for (WebElement each : list) {
            webelementsAsString.add(each.getText());

        }
       return webelementsAsString;
    }

    /*
    Create a utiliy method named : wait
    static method
    @param sec
    @return void
    The integer number that i pass as parameter should be as SECONDS
    Handle checked exception with try / catch
     */

    public static void wait(int sec) {
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
