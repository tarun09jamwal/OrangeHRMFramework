package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class AddEmploymentStatus {
    WebDriver driver;
    WebDriverWait wait;
    By jobDropDown = By.xpath("//span[contains(text(),'Job')]");
    By employmentStatus = By.xpath("//*[contains(text(),'Employment Status')]");
    By addButton = By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']");
    By statusName = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By save = By.xpath("//button[@type='submit']");
    By employmentTable = By.xpath("//div[@class='orangehrm-container']");
    By userDropDown = By.xpath("//span[@class='oxd-userdropdown-tab']");
    By logout = By.xpath("//a[contains(text(),'Logout')]");

    public AddEmploymentStatus(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void JobDropDown() {
        driver.findElement(jobDropDown).click();
        driver.findElement(employmentStatus).click();
    }

    public void AddEmploymentStatus() {
        driver.findElement(addButton).click();
        driver.findElement(statusName).sendKeys("Full Time Engineer");
        driver.findElement(save).click();

    }

    public void VerifyStatus() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(employmentTable));
        boolean isAdminDisplayed = driver.findElement(By.xpath(String.format("//div[contains(text(),'%s')]", "Full Time Engineer"))).isDisplayed();
        Assert.assertTrue(isAdminDisplayed, "User is not added");
        driver.findElement(userDropDown).click();
        driver.findElement(logout).click();
        driver.close();
    }
}
