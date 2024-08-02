package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.SignInPage;

public class CreateNewAccount {
    @When("user click on create new account")
    public void user_click_on_create_new_account() {
            clickOnElement(HomePage.SING_IN_LINK);
    }
    @Then("validate user is in create new account page")
    public void validate_user_is_in_create_new_account_page() {
        String signupSubtitle = getElementText(SignupPage.PAGE_SUBTITLE);
        Assert.assertEquals("Sign Up", "signup__subtitle");
    }
    @When("user enter new account information and click on create account")
    public void user_enter_new_account_information_and_click_on_create_account() {
        sendText(SignUpPage.EMAIL_INPUT, "ziamustafa@hotmail.com");
        sendText(SignUpPage.PASSWORD_INPUT, "786@Mohammad");
        clickOnElement(SignUpPage.LOGIN_BUTTON);
    }
    @Then("validate new account created")
    public void validate_new_account_created() {
        String validateNewAccount = getElementText.("account__information-email")
        Assert.assertEquals(accountInformation);
    }
}
