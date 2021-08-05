package commonUtils;

import Driver.DriverSetup;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class CommonHelper {

    static WebDriver driver = DriverSetup.getDriver();

    public static void openWebPage(String url) {
        driver.navigate().to(url);
    }

    public static void clickWhenReady(WebElement po) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(po)).click();
    }

    public static void verifyElementAppears(WebElement Po) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(Po));
    }

    public static void sendText(WebElement po, String Text) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(po)).sendKeys(Text);
    }

    public static WebElement findElementByText(String tagName, String text) {
        return driver.findElement(By.xpath("//" + tagName + "[contains(text(),'" + text +"'"+ ")]"));

    }


    public static void takeSnapShot(WebDriver driver, String screenshotName) {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("./Screenshots/" + screenshotName + ".png");
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
    }

}