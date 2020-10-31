package com.cybertek.tests.day6_dropdown_review_javafaker;

import com.cybertek.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownTasks {

    WebDriver driver;

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }

    @BeforeMethod
    public void setupMethod() {
        //open a new browser
        driver = WebDriverFactory.getDriver("chrome");
        //maximize page
        driver.manage().window().maximize();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        //get the page
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void test2_verify_state_dropdown() throws InterruptedException {
        //we need to locate dropdown
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        //select Illinois
        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Illinois");
        //select Virginia
        Thread.sleep(1000);
        stateDropdown.selectByValue("VA");
        //select California
        Thread.sleep(1000);
        stateDropdown.selectByIndex(5);
        //Verify final selected option is CA
        String expectedRes = "California";
        String actualRes = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualRes, expectedRes, "Actual vs Expected is not equal!");


    }

    @Test
    public void test3_date_dropdown_verification() throws InterruptedException {
        //TC #3: Selecting date on dropdown and verifying
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        // Already done in BEFORE METHOD

        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));


        //3. Select “December 1 , 1921” and verify it is selected.
        Thread.sleep(2000);
        // Selecting year using text
        yearDropdown.selectByVisibleText("1921");
        Thread.sleep(2000);
        //Selecting month by value attribute
        monthDropdown.selectByValue("11");
        Thread.sleep(2000);
        // Selecting day using index
        dayDropdown.selectByIndex(0);

        // creating expected values in one place
        String expectedYear = "1921";
        String expectedMonth = "December";
        String expectedDay = "1";

        //getting act values from web page

        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        //creating assert lines to compare act vs exp

        Assert.assertEquals(actualYear, expectedYear, "Actual year vs expected year not equal");
        Assert.assertEquals(actualMonth, expectedMonth, "Actual month vs expected month not equal");
        Assert.assertTrue(actualDay.equals(expectedDay), "Actual day vs expected day not equal");


    }


    //TC #4: Selecting value from multiple select dropdown
    @Test
    public void test4_multiple_value_select_dropdown()throws InterruptedException {

        //3. Select all the options from multiple select dropdown

        // Locating dropdown
        Select multipleSelectDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        // Creating the list to store all options from dropdown

        List<WebElement> allOptions = multipleSelectDropdown.getOptions();

        //Loop through the options to select all of them


        for(WebElement eachOption : allOptions){
            Thread.sleep(500);
            eachOption.click(); // clicks each opttion

            //4. Print out all selected values.
            System.out.println("Selected: " + eachOption.getText());

            //Asserting the option ia actually selected or not
            Assert.assertTrue(eachOption.isSelected(),"The option: "+eachOption.getText()+" is not selected!");

        }


        //5. Deselect all values.

        multipleSelectDropdown.deselectAll();

        for(WebElement eachOption : allOptions){
          //  Assert.assertTrue(!eachOption.isSelected()); Both works same
            Assert.assertFalse(eachOption.isSelected());
        }

    }

    @Test
    public void test5_html_dropdown_handling() throws InterruptedException{
        //Locate the HTML dropdown as a regular web element
        WebElement websiteDropdown = driver.findElement(By.xpath("//div[@class='dropdown']/a"));

        //3. Click to non-select dropdown
        websiteDropdown.click();
        Thread.sleep(2000);

        //4. Select Facebook from dropdown
        WebElement facebookLink = driver.findElement(By.xpath("//a[.='Facebook']"));
        Thread.sleep(2000);

        facebookLink.click();
        Thread.sleep(2000);
        //5. Verify title is “Facebook - Log In or Sign Up”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Log In or Sign Up";

        Assert.assertEquals(actualTitle, expectedTitle, "Actual title does not match expected title!");
    }

}