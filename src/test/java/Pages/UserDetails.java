package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserDetails
{
WebDriver driver;
By loginButton = By.xpath("//button[@type='submit']");
By adminPageLink = By.xpath("//a[contains(@href,'/web/index.php/admin/viewAdminModule')]");
By addButton = By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']");
    public UserDetails(WebDriver driver) {
        this.driver = driver;
    }
    public void Login()
    {
        driver.findElement(loginButton).click();
    }

    public void AdminLink()
    {
        driver.findElement(adminPageLink).click();
    }
    public void AddButton(){
        driver.findElement(addButton).click();
    }

}
