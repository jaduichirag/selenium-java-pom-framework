package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtility {

    private final WaitUtility wait;

    public DropdownUtility(WebDriver driver) {
        this.wait = new WaitUtility(driver);
    }

    // =========================================================
    // Private Helper Methods
    // =========================================================

    private Select getSelect(By locator) {
        return new Select(wait.waitForVisibility(locator));
    }

    private Select getSelect(WebElement element) {
        return new Select(element);
    }

    // =========================================================
    // Select Methods
    // =========================================================

    public void selectByVisibleText(By locator, String text) {
        getSelect(locator).selectByVisibleText(text);
    }

    public void selectByVisibleText(WebElement element, String text) {
        getSelect(element).selectByVisibleText(text);
    }

    public void selectByValue(By locator, String value) {
        getSelect(locator).selectByValue(value);
    }

    public void selectByIndex(By locator, int index) {
        getSelect(locator).selectByIndex(index);
    }

    public void selectFirstOption(By locator) {
        getSelect(locator).selectByIndex(0);
    }

    public void selectLastOption(By locator) {

        Select select = getSelect(locator);

        select.selectByIndex(select.getOptions().size() - 1);

    }

    public void selectRandomOption(By locator) {

        Select select = getSelect(locator);

        int size = select.getOptions().size();

        if (size > 0) {

            int random = new Random().nextInt(size);

            select.selectByIndex(random);

        }

    }

    public void selectByPartialText(By locator, String partialText) {

        for (WebElement option : getSelect(locator).getOptions()) {

            if (option.getText().trim().contains(partialText)) {

                option.click();

                break;

            }

        }

    }

    // =========================================================
    // Deselect Methods
    // =========================================================

    public void deselectAll(By locator) {
        getSelect(locator).deselectAll();
    }

    public void deselectByVisibleText(By locator, String text) {
        getSelect(locator).deselectByVisibleText(text);
    }

    public void deselectByValue(By locator, String value) {
        getSelect(locator).deselectByValue(value);
    }

    public void deselectByIndex(By locator, int index) {
        getSelect(locator).deselectByIndex(index);
    }

    // =========================================================
    // Information
    // =========================================================

    public String getSelectedOption(By locator) {

        return getSelect(locator)
                .getFirstSelectedOption()
                .getText();

    }

    public int getOptionCount(By locator) {

        return getSelect(locator)
                .getOptions()
                .size();

    }

    public boolean isMultiple(By locator) {

        return getSelect(locator)
                .isMultiple();

    }

    public List<WebElement> getOptions(By locator) {

        return getSelect(locator)
                .getOptions();

    }

    public List<String> getAllOptions(By locator) {

        List<String> options = new ArrayList<>();

        for (WebElement option : getSelect(locator).getOptions()) {

            options.add(option.getText().trim());

        }

        return options;

    }

    // =========================================================
    // Verification
    // =========================================================

    public boolean verifySelectedOption(By locator,
                                        String expected) {

        return getSelectedOption(locator)
                .equalsIgnoreCase(expected);

    }

    public boolean containsOption(By locator,
                                  String expected) {

        for (WebElement option : getSelect(locator).getOptions()) {

            if (option.getText().trim()
                    .equalsIgnoreCase(expected)) {

                return true;

            }

        }

        return false;

    }

    // =========================================================
    // Multi Select
    // =========================================================

    public void selectAll(By locator) {

        Select select = getSelect(locator);

        if (select.isMultiple()) {

            for (WebElement option : select.getOptions()) {

                option.click();

            }

        }

    }

    // =========================================================
    // Custom Dropdown (React, Angular, Bootstrap)
    // =========================================================

    public void selectCustomDropdown(By dropdown,
                                     By options,
                                     String value) {

        wait.waitForClickable(dropdown).click();

        List<WebElement> optionList =
                wait.waitForAllVisible(options);

        for (WebElement option : optionList) {

            if (option.getText().trim()
                    .equalsIgnoreCase(value)) {

                option.click();

                break;

            }

        }

    }

}