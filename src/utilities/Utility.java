package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }
    /**
     * This method will send text to element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }
    /**
     * This method will select option from dropdown list
     *
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        // Select by visible text
        select.selectByVisibleText(text);
    }
    /**
     * This method will select element
     */
    public void selectMenu(String menu) {
        driver.findElement(By.linkText(menu)).click();
    }
    public WebElement mouseHover(By by) {
        return driver.findElement(by);
    }

    // This method will mouse hover on element
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
//        Thread.sleep(3000);
        // waitUnitVisibilityOfElementLocated(by,2000);
        actions.moveToElement(mouseHoover).build().perform();
    }

    // This method will mouse hover and click the element
    public void mouseHoverAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        //   Thread.sleep(3000);
        //  waitUnitVisibilityOfElementLocated(by,3000);
        actions.moveToElement(mouseHoover).click().build().perform();
    }
    public void dragAndDrop(By drag, By drop) {
        Actions actions = new Actions(driver);
        WebElement draggable = driver.findElement(drag);
        WebElement droppable = driver.findElement(drop);
        actions.dragAndDrop(draggable, droppable).build().perform();
    }

    /**
     * This method verify the text with element
     *
     */
    public boolean verifyText(WebDriver driver, By locator, String expectedText) {
        WebElement element = driver.findElement(locator);
        String actualText = element.getText();
        return actualText.equals(expectedText);
    }


    /**
     * This method select the option from dropdown list
     */
    public void selectMyAccountOption(WebDriver driver, String option) {
        // Locate the My Account dropdown and click on it
        WebElement myAccountDropdown = driver.findElement(By.id("my-account-dropdown"));
        myAccountDropdown.click();

        // Locate the list of options in the dropdown
        List<WebElement> options = driver.findElements(By.cssSelector("#my-account-dropdown .dropdown-menu li"));

        // Iterate through the options and click on the one that matches the given name
        for (WebElement opt : options) {
            if (opt.getText().equals(option)) {
                opt.click();
                break;
            }
        }
    }
    // This method will verify text displayed on web page
    public void verifyText(String expectedMessage, By by, String displayMessage) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }

    //This method will select by value
    public void selectByValueFromDropdown(By by, String text) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByValue(text);
    }

    public void selectByIndexFromDropDown(By by, int index) {
        WebElement element = driver.findElement(by);
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    // This method will clear text from field
    public void clearTextFromField(By by) {
        driver.findElement(by).sendKeys(Keys.CONTROL + "a");
        driver.findElement(by).sendKeys(Keys.DELETE);
    }


}