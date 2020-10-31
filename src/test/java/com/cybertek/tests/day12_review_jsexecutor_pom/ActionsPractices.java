package com.cybertek.tests.day12_review_jsexecutor_pom;

import com.cybertek.utilites.BrowserUtils;
import com.cybertek.utilites.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsPractices {

    /*
TC #16: Double Click Test
1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
2. Switch to iframe.
3. Double click on the text "Double-click me to change my text color."
4. Assert: Text's "style" attribute value contains "red".
 */
    @Test
    public void p2_double_click_test(){


        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        Driver.getDriver().switchTo().frame("iframeResult");

        WebElement textToDoubleClick = Driver.getDriver().findElement(By.id("demo"));

        Actions actions = new Actions(Driver.getDriver());

        actions.doubleClick(textToDoubleClick).perform();

        String expected = "red";
        String actual = textToDoubleClick.getAttribute("style");

        Assert.assertTrue(actual.contains(expected));






    }
/*
TC	#16:	Hover	Test
1.Go	to	https://demos.telerik.com/kendo-ui/dragdrop/index
2.Drag	and	drop	the	small	circle	to	bigger	circle.
3.Assert:
-Text	in	big	circle	changedto:	“You	did	great!”
 */
    @Test

    public void p3_drag_and_drop(){
        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Driver.getDriver().manage().window().maximize();

        //2. Drag and drop the small circle to bigger circle.
        BrowserUtils.wait(3);
        WebElement acceptCookiesButton = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookiesButton.click();
        //Locating circles
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        BrowserUtils.wait(3);

        Actions actions = new Actions(Driver.getDriver());
        //DragAndDrop method expects to arguments:
        // #1-Which webElement you want to drag : SOURCE
        // #2-Where do you want to drop it? : TARGET
        actions.clickAndHold(smallCircle).moveToElement(bigCircle).release().perform();
 //       actions.dragAndDrop(smallCircle, bigCircle).perform();

        //3. Assert:
        //-Text in big circle changed to: “You did great
        String expected = "You did great!";
        String actual = bigCircle.getText();

        Assert.assertTrue(actual.equals(expected));




    }

/*
TC	#17:	Context	Click	–HOMEWORK
1.Go	to	https://the-internet.herokuapp.com/context_menu
2.Right	click	to	the	box.
3.Alert	will	open.
4.Accept	alertNo	assertion	needed	for	this	prac
 */
    @Test

    public void p4_context_click_test_(){

        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");

        Driver.getDriver().manage().window().maximize();

        WebElement box = Driver.getDriver().findElement(By.id("hot-spot"));

        Actions actions = new Actions(Driver.getDriver());

        BrowserUtils.wait(2);
        actions.contextClick(box).perform();

        Alert alert = Driver.getDriver().switchTo().alert();
        BrowserUtils.wait(2);
        alert.accept();




    }



}
