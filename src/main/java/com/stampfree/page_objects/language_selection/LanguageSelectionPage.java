package com.stampfree.page_objects.language_selection;

import com.stampfree.page_objects.intro.IntroPage;
import com.stampfree.utils.AppInteractions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.stampfree.core.drivers.AndroidDriverManager.getDriver;

public class LanguageSelectionPage extends AppInteractions {
    private WebDriver driver =null;
    public LanguageSelectionPage(){
        driver = getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@text='Next']")
    private WebElement nextButton;
    public IntroPage clickNextButton(){
        nextButton.click();
        return new IntroPage();
    }
}
