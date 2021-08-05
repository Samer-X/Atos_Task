package Register_TC;

import Data.LoadProperties;
import Driver.DriverSetup;
import commonUtils.CommonHelper;
import commonUtils.RandomSource;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import registrationPage.RegistrationPageHelper;

public class Register extends DriverSetup {

    String URL = LoadProperties.useData.getProperty("URL");
    String firstName = RandomSource.nameWithFirstCapitalLetter(7);
    String lastName = RandomSource.nameWithFirstCapitalLetter(7);
    String phoneNumber = RandomSource.generateRandomNumber(11);
    String email = RandomSource.generateRandomEmail(7);
    String password = RandomSource.getPassword(7);


    @BeforeTest()
    void initiate() {
        DriverSetup.driverConf("chrome");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    void registerUsingValidData() throws InterruptedException {
        CommonHelper.openWebPage(URL);
        RegistrationPageHelper registrationPageHelper = new RegistrationPageHelper(driver);
        registrationPageHelper.registerUsingValidData(firstName, lastName, phoneNumber, email, password);
        registrationPageHelper.verifyHomePageIsOpened(firstName, lastName);
    }

    @AfterTest()
    void closure() {
        driver.close();
        driver.quit();
    }
}
