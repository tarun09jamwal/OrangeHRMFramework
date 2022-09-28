package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class EmploymentStatus extends BaseClass {
    @Given("User is logged in")
    public void user_is_logged_in() throws IOException {
        Setup();
        pageFactory.getUserDetails().Login();
    }

    @When("navigate Admin page")
    public void navigate_admin_page() {
        pageFactory.getUserDetails().AdminLink();
    }

    @When("User navigates to the User Management page click on job dropdown select Employment Status in dropdown option")
    public void user_navigates_to_the_user_management_page_click_on_job_dropdown_select_employment_status_in_dropdown_option() {
        pageFactory.getAddEmploymentStatus().JobDropDown();
    }

    @Then("Click on add button and fill Employment Status and click save")
    public void click_on_add_button_and_fill_employment_status_and_click_save() {
        pageFactory.getAddEmploymentStatus().AddEmploymentStatus();

    }

    @Then("Verify the Employment Status and click on logout")
    public void verify_the_employment_status_and_click_on_logout() {
        pageFactory.getAddEmploymentStatus().VerifyStatus();

    }

}
