package tek.bdd.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tek.bdd.pages.AccountPage;
import tek.bdd.pages.SignUpPage;
import tek.bdd.utility.RandomGenerator;
import tek.bdd.utility.SeleniumUtility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateNewAccountSteps extends SeleniumUtility {
    private static String emailToUse;

    @When("user enter {string}, {string}, and {string}")
    public void userEnterNewAccountInfo(String name, String email, String password) {
        emailToUse = email.equalsIgnoreCase("random")
                ? RandomGenerator.generateRandomEmail()
                : email;

        sendText(SignUpPage.NAME_INPUT, name);
        sendText(SignUpPage.EMAIL_INPUT, emailToUse);
        sendText(SignUpPage.PASSWORD_INPUT, password);
        sendText(SignUpPage.CONFIRM_PASSWORD, password);
    }

    @Then("validate user is in account page")
    public void validateUserInAccountPage() {
        String actualText = getElementText(AccountPage.PROFILE_PAGE_TITLE);
        Assert.assertEquals("Account page should contain 'Your Profile' text", "Your Profile", actualText);
    }

    @Then("validate email address in account page match")
    public void validateEmailAddressInAccountPageMatch() {
        String actualEmail = getElementText(AccountPage.PROFILE_EMAIL_TEXT);
        Assert.assertEquals("Email in account page should match with email used in create account step", emailToUse, actualEmail);
    }

    @When("user enter new account info")
    public void user_enter_new_account_info(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        String email = data.get("email");
        String name = data.get("name");
        String password = data.get("password");

        emailToUse = email.equalsIgnoreCase("random")
                ? RandomGenerator.generateRandomEmail()
                : email;

        sendText(SignUpPage.NAME_INPUT, name);
        sendText(SignUpPage.EMAIL_INPUT, emailToUse);
        sendText(SignUpPage.PASSWORD_INPUT, password);
        sendText(SignUpPage.CONFIRM_PASSWORD, password);
    }

    @When("user enter new account info using list Data")
    public void user_enter_new_account_info_using_list_data(DataTable dataTable) {
        List<String> data = dataTable.asList(String.class);
        String name = data.get(0);
        String email = data.get(1);
        String password = data.get(2);

        emailToUse = email.equalsIgnoreCase("random")
                ? RandomGenerator.generateRandomEmail()
                : email;

        sendText(SignUpPage.NAME_INPUT, name);
        sendText(SignUpPage.EMAIL_INPUT, emailToUse);
        sendText(SignUpPage.PASSWORD_INPUT, password);
        sendText(SignUpPage.CONFIRM_PASSWORD, password);
    }

    @When("user enter new account as list of list")
    public void user_enter_new_account_as_list_of_list(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        String name = data.get(0).get(0);
        String email = data.get(0).get(1);
        String password = data.get(0).get(2);

        emailToUse = email.equalsIgnoreCase("random")
                ? RandomGenerator.generateRandomEmail()
                : email;

        sendText(SignUpPage.NAME_INPUT, name);
        sendText(SignUpPage.EMAIL_INPUT, emailToUse);
        sendText(SignUpPage.PASSWORD_INPUT, password);
        sendText(SignUpPage.CONFIRM_PASSWORD, password);
    }

    @When("user enter new account as list of maps")
    public void user_enter_new_account_as_list_of_maps(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String email = data.get(0).get("email");
        String name = data.get(0).get("name");
        String password = data.get(0).get("password");

        emailToUse = email.equalsIgnoreCase("random")
                ? RandomGenerator.generateRandomEmail()
                : email;

        sendText(SignUpPage.NAME_INPUT, name);
        sendText(SignUpPage.EMAIL_INPUT, emailToUse);
        sendText(SignUpPage.PASSWORD_INPUT, password);
        sendText(SignUpPage.CONFIRM_PASSWORD, password);
    }

    @Then("validate field error messages")
    public void validate_field_error_messages(DataTable dataTable) {
        List<String> expectedData = dataTable.asList(String.class);
        List<WebElement> errorElements = getElements(SignUpPage.ERROR_MESSAGE);

        Assert.assertEquals("Number of error messages should be the same as expected", expectedData.size(), errorElements.size());

        for (int index = 0; index < expectedData.size(); index++) {
            String expected = expectedData.get(index);
            String actual = errorElements.get(index).getText();

            Assert.assertEquals("Error message should match", expected, actual);
        }
    }

    @Then("validate field error messages using map")
    public void validate_field_error_messages_using_map(DataTable dataTable) {
        Map<String, String> expectedData = dataTable.asMap(String.class, String.class);
        List<WebElement> errorElements = getElements(SignUpPage.ERROR_MESSAGE);

        Assert.assertEquals("Number of error messages should be the same as expected", expectedData.size(), errorElements.size());

        Map<String, String> actualErrors = new HashMap<>();
        for (WebElement element : errorElements) {
            String text = element.getText();
            String key = text.split(" ")[0];
            actualErrors.put(key, text);
        }

        for (String key : expectedData.keySet()) {
            Assert.assertEquals("Error message should match", expectedData.get(key), actualErrors.get(key));
        }
    }
}
