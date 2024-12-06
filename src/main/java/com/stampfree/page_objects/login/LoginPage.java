package com.stampfree.page_objects.login;

import com.stampfree.page_objects.forgot_password.ForgotPasswordPage;
import com.stampfree.utils.AppInteractions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.stampfree.core.drivers.AndroidDriverManager.getDriver;

public class LoginPage extends AppInteractions {
    private WebDriver driver = null;

    public LoginPage() {
        driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]/*/*[@class='android.widget.EditText'])[1]")
    private WebElement emailField;
    @FindBy(xpath = "//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[@text='\uF06E']]")
    private WebElement passwordField;
    @FindBy(xpath = "")
    private WebElement eyeToggle;
    @FindBy(xpath = "//*[@class='android.view.ViewGroup' and ./*[@text='Login']]")
    private WebElement loginButton;
    @FindBy(xpath = "")
    private WebElement forgotButton;

    public void enterEmail(String emailID) {
        fixedWait();
        clearTextfield(emailField);
        inputText(emailField, emailID);
    }

    public void enterPassword(String password) {
        fixedWait();
        clearTextfield(passwordField);
        inputText(passwordField, password);
    }

    public void turnEyeToggleOn() {
        eyeToggle.click();
    }

    public void clickLoginButton() {
        fixedWait();
        clickButton(loginButton);
    }

    public ForgotPasswordPage clickForgotButton()
    {
        fixedWait();
        clickButton(forgotButton);
        return new ForgotPasswordPage();
    }
}
