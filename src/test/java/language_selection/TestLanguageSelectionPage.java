package language_selection;

import com.stampfree.page_objects.intro.IntroPage;
import com.stampfree.page_objects.language_selection.LanguageSelectionPage;
import org.junit.jupiter.api.Test;

public class TestLanguageSelectionPage {
    private LanguageSelectionPage languageSelectionPage;
    private IntroPage introPage;

    @Test()
    public void testUserRedirectsToIntroPage() {
        languageSelectionPage = new LanguageSelectionPage();
        introPage = languageSelectionPage.clickNextButton();
    }
}
