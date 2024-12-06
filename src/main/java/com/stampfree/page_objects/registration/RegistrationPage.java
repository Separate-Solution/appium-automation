package com.stampfree.page_objects.registration;

import com.stampfree.page_objects.login.LoginPage;
import com.stampfree.utils.AppInteractions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.stampfree.core.drivers.AndroidDriverManager.getDriver;

public class RegistrationPage extends AppInteractions {
    private WebDriver driver = null;

    public RegistrationPage() {
        driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]/*/*[@class='android.widget.EditText'])[1]")
    private WebElement emailField;
    @FindBy(xpath = "//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[@text='\uF06E']]")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@text='Already have an account? Login']")
    private WebElement loginLink;

    public LoginPage clickLoginLink() {
        fixedWait();
        clickButton(loginLink);
        return new LoginPage();
    }
}
