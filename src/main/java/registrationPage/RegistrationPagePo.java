package registrationPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPagePo {
    @FindBy(name = "firstname")
    WebElement firstNameField;

    @FindBy(name = "lastname")
    WebElement lastNameField;

    @FindBy(name = "phone")
    WebElement phoneNumber;

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(name = "confirmpassword")
    WebElement confirmPasswordField;

    @FindBy(xpath = "//button[text()=' Sign Up']")
    WebElement signUpButton;

    @FindBy(xpath = "//a[text()='Buy Now']")
    WebElement buyNowButton;


}
