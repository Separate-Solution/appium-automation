package intro;

import com.stampfree.page_objects.intro.IntroPage;
import com.stampfree.page_objects.language_selection.LanguageSelectionPage;
import com.stampfree.page_objects.login.LoginPage;
import com.stampfree.page_objects.registration.RegistrationPage;
import org.junit.jupiter.api.Test;

public class TestIntroPage {
    private LanguageSelectionPage languageSelectionPage;
    private IntroPage introPage;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;

    @Test()
    public void testUserIsAbleToSkip() {
        languageSelectionPage = new LanguageSelectionPage();
        introPage = languageSelectionPage.clickNextButton();
        introPage.clickSkipButton();
        registrationPage = introPage.clickNextButton();
        loginPage = registrationPage.clickLoginLink();
//        loginPage.enterEmail("dimple1@yopmail.com");
//        loginPage.enterPassword("Test@123");
//        loginPage.clickLoginButton();
    }
}
