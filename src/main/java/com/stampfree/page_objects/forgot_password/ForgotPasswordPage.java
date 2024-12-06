package com.stampfree.page_objects.forgot_password;

import com.stampfree.core.drivers.AndroidDriverManager;
import com.stampfree.utils.AppInteractions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.stampfree.core.drivers.AndroidDriverManager.getDriver;

public class ForgotPasswordPage extends AppInteractions {
    private WebDriver driver = null;
    public ForgotPasswordPage() {
        driver = getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]/*/*[@class='android.widget.EditText'])[1]")
    private WebElement emailField;
    @FindBy(xpath = "")
    private WebElement submitButton;

    public void enterEmail(String emailID) {
        inputText(emailField, emailID);
    }
    public LoginPage clickOnSubmit() {
        clickButton(submitButton);
        return new LoginPage();
    }
}
