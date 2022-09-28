package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class AddTitle extends BaseClass {
    @Given("add username and password and click login")
    public void add_username_and_password_and_click_login() throws IOException {
        Setup();
        pageFactory.getUserDetails().Login();
        System.out.println("User clicked on login page.");
    }

    @When("User navigates to the PIM page click on Admin page")
    public void user_navigates_to_the_pim_page_click_on_admin_page() {
        pageFactory.getUserDetails().AdminLink();
        System.out.println("User clicked on admin page link");
    }

    @When("User navigated to the User Management page click on job dropdown select job title in dropdown option")
    public void user_navigated_to_the_user_management_page_click_on_job_dropdown_select_job_title_in_dropdown_option() {
        pageFactory.getJobTitle().Job();
    }

    @When("click on add button on job titles page")
    public void click_on_add_button_on_job_titles_page() {
        pageFactory.getJobTitle().addTitleButton();
    }

    @Then("Fill the job title details and click save")
    public void fill_the_job_title_details_and_click_save() {
        pageFactory.getJobTitle().JobTitleDetails();
    }

    @Then("Verify the added job title  and click on logout")
    public void verify_the_added_job_title_and_click_on_logout() {
        pageFactory.getJobTitle().VerifyJobTitle();
    }

}
