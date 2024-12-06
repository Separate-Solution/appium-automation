package com.stampfree.page_objects.intro;

import com.stampfree.page_objects.registration.RegistrationPage;
import com.stampfree.utils.AppInteractions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.stampfree.core.drivers.AndroidDriverManager.getDriver;

public class IntroPage extends AppInteractions {
    @FindBy(xpath = "//*[@text='Next']")
    private WebElement nextButton;
    @FindBy(xpath = "//*[@text='Skip']")
    private WebElement skipButton;
    @FindBy(xpath = "")
    private WebElement pageTitle;

    private WebDriver driver = null;

    public IntroPage() {
        driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage clickNextButton() {
        fixedWait();
        nextButton.click();
        return new RegistrationPage();
    }

    public void clickSkipButton() {
        fixedWait();
        skipButton.click();
    }
    public String getPageTitle(){
        return pageTitle.getText();
    }
}
