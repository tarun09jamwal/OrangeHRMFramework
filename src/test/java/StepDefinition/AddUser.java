package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class AddUser extends BaseClass {
    @Given("fill username and password and click login")
    public void fill_username_and_password_and_click_login() throws IOException {
        Setup();
        pageFactory.getUserDetails().Login();
        System.out.println("User clicked on login page.");

    }

    @When("User is navigate to the PIM page click on Admin page")
    public void user_is_navigate_to_the_pim_page_click_on_admin_page() {
        pageFactory.getUserDetails().AdminLink();
        System.out.println("User clicked on admin page link");
    }

    @When("User navigated to the User Management page and click Add button")
    public void user_navigated_to_the_user_management_page_and_click_add_button() {
        pageFactory.getUserDetails().AddButton();
        System.out.println("User clicked on add button");
    }

    @Then("Fill the user details and click save")
    public void fill_the_user_details_and_click_save() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Verify the added user and click on logout")
    public void verify_the_added_user_and_click_on_logout() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();

    }
}