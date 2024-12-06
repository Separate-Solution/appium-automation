package forgot_password;

import com.stampfree.page_objects.forgot_password.ForgotPasswordPage;
import com.stampfree.page_objects.login.LoginPage;
import org.junit.jupiter.api.Test;

public class TestForgotPasswordPage {
    private ForgotPasswordPage forgotPasswordPage;
    private LoginPage loginPage;

    @Test
    public void testForgotPassword()
    {
        loginPage = new LoginPage();
        forgotPasswordPage=loginPage.clickForgotButton();
        forgotPasswordPage.enterEmail("dimple1@yopmail.com");
        forgotPasswordPage.clickOnSubmit();
    }
}
