package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class JobCategorie {
    WebDriver driver;
    WebDriverWait wait;
    By jobDropDown = By.xpath("//span[contains(text(),'Job')]");
    By JobCategories = By.xpath("//*[contains(text(),'Job Categories')]");
    By addButton = By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']");
    By name = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By saveButton = By.xpath("//button[@type='submit']");
    By jobCategories = By.xpath("//div[@class='orangehrm-container']");
    By userDropDown = By.xpath("//span[@class='oxd-userdropdown-tab']");
    By logout = By.xpath("//a[contains(text(),'Logout')]");

    public JobCategorie(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void JobDropDown() {
        driver.findElement(jobDropDown).click();
        driver.findElement(JobCategories).click();
    }

    public void JobDetails() {
        driver.findElement(addButton).click();
        driver.findElement(name).sendKeys("Engineer");
        driver.findElement(saveButton).click();
    }

    public void VerifyJobCategorie() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(jobCategories));
        boolean isAdminDisplayed = driver.findElement(By.xpath(String.format("//div[contains(text(),'%s')]", "Engineer"))).isDisplayed();
        Assert.assertTrue(isAdminDisplayed, "User is not added");
        driver.findElement(userDropDown).click();
        driver.findElement(logout).click();
        driver.close();
    }
}
