package com.cybertek.tests.day3_cssSelector_xpath;

import com.cybertek.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
TC #3: PracticeCybertek/ForgotPassword URL verification
1.Open Chrome browser
2.Go to http://practice.cybertekschool.com/forgot_password
3.Enter any email into input box
4.Click on Retrieve password
5.Verify URL contains: Expected: “email_sent”
6.Verify textbox displayed the content as expected.Expected: “Your e-mail’s been sent!
 */
public class WT_CybertekLinkVerification {

    public static void main(String[] args) {
/*
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
*/
        WebDriver driver = WebDriverFactory.getDriver("firefox");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //driver.findElement(By.name("email")).sendKeys("anyemail@domain.com");
        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("anyemail@domain.com");

      //  driver.findElement(By.id("form_submit")).click();
        WebElement retrivePasswordButton = driver.findElement(By.id("form_submit"));
        retrivePasswordButton.click();

        String expectedInUrl = "email_sent";
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.contains(expectedInUrl)){
            System.out.println("URL verification passed!");
        }else{
            System.out.println("URL verification failed!!!");
        }
        // verify the text
        //  String actualText = driver.findElement(By.name("confirmation_message")).getText();
        WebElement confirmationMessage = driver.findElement(By.name("confirmation_message"));
        String actualText = confirmationMessage.getText();
        String expectedText = "Your e-mail's been sent!";

        System.out.println("actualText = " + actualText);
        System.out.println("expectedText = " + expectedText);


        if (actualText.equals(expectedText)) {
            System.out.println("Header text value verification Passed!");
        }else{
            System.out.println("Header text value verification Failed!!!");
        }

        //verify if the web element is displayed or not
        if(confirmationMessage.isDisplayed()){
            System.out.println("Confirmation message is displayed.Verification PASSED!");
        }else{
            System.out.println("Confirmation message is NOT displayed.Verification FAILED!!!");
        }






    }


}
