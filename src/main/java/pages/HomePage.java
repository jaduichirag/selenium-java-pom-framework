package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class HomePage extends BasePage {

    private By logo = By.xpath("//img[@alt='Website for automation practice']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoDisplayed() {
        return isDisplayed(logo);
    }
}