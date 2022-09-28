package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;
    private UserDetails userDetails;
    private JobTitle jobTitle;
    private JobCategorie jobCategorie;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public UserDetails getUserDetails() {
        if (userDetails == null) {
            userDetails = new UserDetails(driver);
        }
        return userDetails;
    }

    public JobTitle getJobTitle() {
        if (jobTitle == null) {
            jobTitle = new JobTitle(driver);
        }
        return jobTitle;
    }

    public JobCategorie getJobCategorie() {
        if (jobCategorie == null) {
            jobCategorie = new JobCategorie(driver);
        }
        return jobCategorie;
    }
}
