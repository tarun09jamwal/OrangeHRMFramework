package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobTitle {
    WebDriver driver;
    WebDriverWait wait;
    By jobDropDown = By.xpath("//span[contains(text(),'Job')]");
    By jobTitleInDropDown = By.xpath("//*[contains(text(),'Job Titles')]");
    By addButton = By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']");
    By jobTitle = By.xpath("//input[@class='oxd-input oxd-input--active oxd-input--error']");
    By jobDescription = By.xpath("//textarea[@placeholder='Type description here']");
    By addNote = By.xpath("//textarea[@placeholder='Add note']");
    By submitButton = By.xpath("//button[@type='submit']");

    public JobTitle(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void Job()
    {
        driver.findElement(jobDropDown).click();
        driver.findElement(jobTitleInDropDown).click();
    }
    public void addTitleButton()
    {
        driver.findElement(addButton).click();
    }

    public void JobTitleDetails()
    {
        driver.findElement(jobTitle).sendKeys("QA Enngineers");
        driver.findElement(jobDescription).sendKeys("I am test Engineer");
        driver.findElement(addNote).sendKeys("Hi");
        driver.findElement(submitButton).click();


    }
}
