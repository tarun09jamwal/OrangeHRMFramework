package Pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class UserDetails {
    WebDriver driver;
    WebDriverWait wait;
    String uniqueName;
    By loginButton = By.xpath("//button[@type='submit']");
    By adminPageLink = By.xpath("//a[contains(@href,'/web/index.php/admin/viewAdminModule')]");
    By addButton = By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']");
    By userRoleDropDown = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
    By userDropDownSelectAdmin = By.xpath("//*[contains(text(),'Admin')]");
    By statusDropdown = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]");
    By statusDropDownSelectEnabled = By.xpath("//*[contains(text(),'Enabled')]");
    By password = By.xpath("(//input[@type='password'])[1]");
    By confirmPassword = By.xpath("(//input[@type='password'])[2]");
    By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
    By userName = By.xpath("(//div/input[@class='oxd-input oxd-input--active'])[2]");
    By errorMessage = By.xpath("//span[contains(@class,'oxd-input-field-error-message')]");
    By saveButton = By.xpath("//button[@type='submit']");
    By userDropDown = By.xpath("//span[@class='oxd-userdropdown-tab']");
    By logout = By.xpath("//a[contains(text(),'Logout')]");
    By recordFound = By.xpath("//div[@class='oxd-table-header']");
    By titleRecord = By.xpath("//div[@class='orangehrm-container']");


    public UserDetails(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void Login() {
        driver.findElement(loginButton).click();
    }

    public void AdminLink() {
        driver.findElement(adminPageLink).click();
    }

    public void AddButton() {
        driver.findElement(addButton).click();
    }

    public void UserDetails() throws IOException {
        String randomNumber = String.valueOf((int) (Math.random() * (100 - 50 + 1) + 50));
        uniqueName = "Odis09adalwin" + randomNumber;
        String path = System.getProperty("user.dir") + "//src//test//java//TestData//OrangeUserData.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String userPasword = sheet.getRow(1).getCell(0).getStringCellValue();
        String userConfirmPassword = sheet.getRow(1).getCell(1).getStringCellValue();
        String employee = sheet.getRow(1).getCell(2).getStringCellValue();
        driver.findElement(userRoleDropDown).click();
        driver.findElement(userDropDownSelectAdmin).click();
        driver.findElement(statusDropdown).click();
        driver.findElement(statusDropDownSelectEnabled).click();
        driver.findElement(password).sendKeys(userPasword);
        driver.findElement(confirmPassword).sendKeys(userConfirmPassword);
        driver.findElement(employeeName).sendKeys(employee);
        driver.findElement(By.xpath("//*[contains(text(),'Odis')]")).click();
        driver.findElement(userName).sendKeys(uniqueName);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(errorMessage));
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        driver.findElement(saveButton).sendKeys(Keys.ENTER);
    }

    public void verifyUser() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(recordFound));
        boolean isAdminDisplayed = driver.findElement(By.xpath(String.format("//div[contains(text(),'%s')]", uniqueName))).isDisplayed();
        Assert.assertTrue(isAdminDisplayed, "User is not added");
        driver.findElement(userDropDown).click();
        driver.findElement(logout).click();
        driver.close();
    }

}
