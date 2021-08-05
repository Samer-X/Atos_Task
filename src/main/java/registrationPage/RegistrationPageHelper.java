package registrationPage;

import commonUtils.CommonHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPageHelper extends RegistrationPagePo {


    public RegistrationPageHelper(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void enterFirstName(String firstName) {
        CommonHelper.sendText(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        CommonHelper.sendText(lastNameField, lastName);
    }


    public void enterPhoneNumber(String email) {
        CommonHelper.sendText(phoneNumber, email);
    }

    public void enterEmail(String email) {
        CommonHelper.sendText(emailField, email);
    }


    public void enterPassword(String password) {
        CommonHelper.sendText(passwordField, password);
    }

    public void confirmPassword(String password) {
        CommonHelper.sendText(confirmPasswordField, password);
    }


    public void clickSignUpButton() {
        CommonHelper.clickWhenReady(signUpButton);
    }


    public void registerUsingValidData(String firstName, String lastName, String phoneNo, String email, String password) {
        this.enterFirstName(firstName);
        this.enterLastName(lastName);
        this.enterPhoneNumber(phoneNo);
        this.enterEmail(email);
        this.enterPassword(password);
        this.confirmPassword(password);
        this.clickSignUpButton();
    }

    public void verifyHomePageIsOpened(String firstName, String lastName) throws InterruptedException {
        Thread.sleep(3000);
        CommonHelper.verifyElementAppears(buyNowButton);
        CommonHelper.verifyElementAppears(CommonHelper.findElementByText("h3", firstName + " " + lastName));
    }
}

