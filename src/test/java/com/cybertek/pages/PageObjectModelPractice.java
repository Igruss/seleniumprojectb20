package com.cybertek.pages;

import org.testng.annotations.Test;

public class PageObjectModelPractice {

    @Test
    public void login_to_smartbear(){
        LoginPage loginPage = new LoginPage();
        //get URL
        loginPage.usernameInput.sendKeys("anyusername");
        

    }


}
