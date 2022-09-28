package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class AddJobCategorie extends BaseClass {
    @Given("Enter username and password and click login")
    public void Enter_username_and_password_and_click_login() throws IOException {
        Setup();
        pageFactory.getUserDetails().Login();
    }

    @When("User navigate to the PIM page click on Admin page")
    public void User_navigate_to_the_PIM_page_click_on_Admin_page() {
        pageFactory.getUserDetails().AdminLink();
    }

    @When("User navigates to the User Management page click on job dropdown select job categorie in dropdown option")
    public void User_navigates_to_the_User_Management_page_click_on_job_dropdown_select_job_categorie_in_dropdown_option() {
        pageFactory.getJobCategorie().JobDropDown();
    }

    @Then("Click on add button and fill job categorie and click save")
    public void Click_on_add_button_and_fill_job_categorie_and_click_save() {
        pageFactory.getJobCategorie().JobDetails();
    }

    @Then("Verify the job categorie and click on logout")
    public void Verify_the_job_categorie_and_click_on_logout() {
        pageFactory.getJobCategorie().VerifyJobCategorie();

    }
}
