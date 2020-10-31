package com.cybertek.tests.day12_review_jsexecutor_pom;

import com.cybertek.utilites.BrowserUtils;
import com.cybertek.utilites.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UploadPractce {

    @Test

    public void uploading_file_test(){

        Driver.getDriver().get("http://practice.cybertekschool.com/upload");
        Driver.getDriver().manage().window().maximize();

        String path = "C:\\Users\\Owner\\Pictures\\IMG_1415.jpg";

        WebElement uploadInput = Driver.getDriver().findElement(By.id("file-upload"));

        BrowserUtils.wait(2);

        uploadInput.sendKeys(path);

        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));

        BrowserUtils.wait(2);

        uploadButton.click();


    }

}
