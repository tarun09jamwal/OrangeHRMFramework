package Pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class JobTitle {
    WebDriver driver;
    WebDriverWait wait;
    By jobDropDown = By.xpath("//span[contains(text(),'Job')]");
    By jobTitleInDropDown = By.xpath("//*[contains(text(),'Job Titles')]");
    By addButton = By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']");
    By jobTitle = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By jobDescription = By.xpath("//textarea[@placeholder='Type description here']");
    By addNote = By.xpath("//textarea[@placeholder='Add note']");
    By submitButton = By.xpath("//button[@type='submit']");
    By titleRecord = By.xpath("//div[@class='orangehrm-container']");
    By userDropDown = By.xpath("//span[@class='oxd-userdropdown-tab']");
    By logout = By.xpath("//a[contains(text(),'Logout')]");


    public JobTitle(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void Job() {
        driver.findElement(jobDropDown).click();
        driver.findElement(jobTitleInDropDown).click();
    }

    public void addTitleButton() {
        driver.findElement(addButton).click();
    }

    public void JobTitleDetails() throws IOException {

        String path = System.getProperty("user.dir") + "//src//test//java//TestData//OrangeUserData.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String jobtitle = sheet.getRow(1).getCell(3).getStringCellValue();
        String jobdescription = sheet.getRow(1).getCell(4).getStringCellValue();
        String note = sheet.getRow(1).getCell(5).getStringCellValue();
        wait.until(ExpectedConditions.elementToBeClickable(jobTitle));
        driver.findElement(jobTitle).sendKeys(jobtitle);
        driver.findElement(jobDescription).sendKeys(jobdescription);
        driver.findElement(addNote).sendKeys(note);
        driver.findElement(submitButton).click();
    }

    public void VerifyJobTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleRecord));
        boolean isAdminDisplayed = driver.findElement(By.xpath(String.format("//div[contains(text(),'%s')]", "QA Engineers"))).isDisplayed();
        Assert.assertTrue(isAdminDisplayed, "User is not added");
        driver.findElement(userDropDown).click();
        driver.findElement(logout).click();
        driver.close();
    }
}
