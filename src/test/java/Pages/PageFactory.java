package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;
    private UserDetails userDetails;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public UserDetails getUserDetails() {
        if (userDetails == null) {
            userDetails = new UserDetails(driver);
        }
        return userDetails;
    }
}
