package com.cybertek.tests.day13_pom_synchroniztion;

import com.cybertek.pages.LoginPage;
import com.cybertek.utilites.ConfigurationReader;
import com.cybertek.utilites.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTests_SB {

    LoginPage loginPage;

    @Test (description = "entering incorrect username")
    public void negative_login_test1(){

        Driver.getDriver().get(ConfigurationReader.getProperty("smartbearUrl"));

        loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("adafimer");

       // String password = ConfigurationReader.getProperty("smartbear_password");
        loginPage.passwordInput.sendKeys("test");

        loginPage.loginButton.click();

        Assert.assertTrue(loginPage.errorMessage.isDisplayed(),"Error mesage is not displayed" +
                "Verification FAILED!!!");



    }

    @Test ( description = "using login method for negative test")
    public void negative_login_test(){

        Driver.getDriver().get(ConfigurationReader.getProperty("smartbearUrl"));

        loginPage = new LoginPage();

        String username= "wrongusername";
        String password = ConfigurationReader.getProperty("smartbear_password");

        loginPage.login(username,password);

        Assert.assertTrue(loginPage.errorMessage.isDisplayed(),"Error mesage is not displayed" +
                "Verification FAILED!!!");


    }



}
