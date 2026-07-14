package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ActionUtility;
import utils.AlertUtility;
import utils.DropdownUtility;
import utils.FrameUtility;
import utils.JavaScriptUtility;
import utils.ScreenshotUtility;
import utils.WaitUtility;
import utils.WindowUtility;

public abstract class BasePage {

	protected final WebDriver driver;

	protected final WaitUtility wait;
	protected final JavaScriptUtility js;
	protected final ActionUtility action;
	protected final DropdownUtility dropdown;
	protected final AlertUtility alert;
	protected final FrameUtility frame;
	protected final WindowUtility window;
	protected final ScreenshotUtility screenshot;

	public BasePage(WebDriver driver) {

		this.driver = driver;

		wait = new WaitUtility(driver);

		js = new JavaScriptUtility(driver);

		action = new ActionUtility(driver);

		dropdown = new DropdownUtility(driver);

		alert = new AlertUtility(driver);

		frame = new FrameUtility(driver);

		window = new WindowUtility(driver);

		screenshot = new ScreenshotUtility(driver);

	}

	// =====================================================
	// Find Element
	// =====================================================

	protected WebElement find(By locator) {

		return wait.waitForVisibility(locator);

	}

	protected List<WebElement> findAll(By locator) {

		return wait.waitForAllVisible(locator);

	}

	// =====================================================
	// Click
	// =====================================================

	public void click(By locator) {

		wait.waitForClickable(locator).click();

	}

	// =====================================================
	// Type
	// =====================================================

	public void type(By locator, String text) {

		WebElement element = wait.waitForVisibility(locator);

		element.clear();

		element.sendKeys(text);

	}

	// =====================================================
	// Clear
	// =====================================================

	public void clear(By locator) {

		wait.waitForVisibility(locator).clear();

	}

	// =====================================================
	// Get Text
	// =====================================================

	public String getText(By locator) {

		return wait.waitForVisibility(locator).getText();

	}

	// =====================================================
	// Get Attribute
	// =====================================================

	public String getAttribute(By locator, String attribute) {

		return wait.waitForVisibility(locator).getDomAttribute(attribute);

	}

	// =====================================================
	// Displayed
	// =====================================================

	public boolean isDisplayed(By locator) {

		return wait.waitForVisibility(locator).isDisplayed();

	}

	// =====================================================
	// Enabled
	// =====================================================

	public boolean isEnabled(By locator) {

		return wait.waitForVisibility(locator).isEnabled();

	}

	// =====================================================
	// Selected
	// =====================================================

	public boolean isSelected(By locator) {

		return wait.waitForVisibility(locator).isSelected();

	}

	// =====================================================
	// Count
	// =====================================================

	public int getElementCount(By locator) {

		return findAll(locator).size();

	}
	// =====================================================
	// Page Information
	// =====================================================

	public String getTitle() {

		return driver.getTitle();

	}

	public String getCurrentUrl() {

		return driver.getCurrentUrl();

	}

	// =====================================================
	// Browser Navigation
	// =====================================================

	public void refresh() {

		driver.navigate().refresh();

	}

	public void back() {

		driver.navigate().back();

	}

	public void forward() {

		driver.navigate().forward();

	}

	// =====================================================
	// JavaScript Wrapper
	// =====================================================

	public void jsClick(By locator) {

		js.jsClick(locator);

	}

	public void jsSendKeys(By locator, String text) {

		js.jsSendKeys(locator, text);

	}

	public void scrollToElement(By locator) {

		js.scrollToElement(locator);

	}

	public void scrollToTop() {

		js.scrollToTop();

	}

	public void scrollToBottom() {

		js.scrollToBottom();

	}

	public void scrollBy(int x, int y) {

		js.scrollBy(x, y);

	}

	public void highlight(By locator) {

		js.highlightElement(locator);

	}

	public void flash(By locator) {

		js.flash(locator);

	}

	public void zoom(int percentage) {

		js.zoom(percentage);

	}

	// =====================================================
	// Mouse Actions
	// =====================================================

	public void hover(By locator) {

		action.hover(locator);

	}

	public void doubleClick(By locator) {

		action.doubleClick(locator);

	}

	public void rightClick(By locator) {

		action.rightClick(locator);

	}

	public void dragAndDrop(By source, By target) {

		action.dragAndDrop(source, target);

	}

	public void moveToElement(By locator) {

		action.moveToElement(locator);

	}

	public void moveByOffset(int x, int y) {

		action.moveByOffset(x, y);

	}

	// =====================================================
	// Keyboard Actions
	// =====================================================

	public void pressEnter(By locator) {

		action.pressEnter(locator);

	}

	public void pressTab(By locator) {

		action.pressTab(locator);

	}

	public void pressEscape() {

		action.pressEscape();

	}

	public void pressKey(By locator, org.openqa.selenium.Keys key) {

		action.pressKey(locator, key);

	}

	// =====================================================
	// Dropdown Wrapper
	// =====================================================

	public void selectByVisibleText(By locator,
	                                String text) {

	    dropdown.selectByVisibleText(locator, text);

	}

	public void selectByValue(By locator,
	                          String value) {

	    dropdown.selectByValue(locator, value);

	}

	public void selectByIndex(By locator,
	                          int index) {

	    dropdown.selectByIndex(locator, index);

	}

	public String getSelectedOption(By locator) {

	    return dropdown.getSelectedOption(locator);

	}

	public List<String> getDropdownOptions(By locator) {

	    return dropdown.getAllOptions(locator);

	}

	public void selectCustomDropdown(By dropdownLocator,
	                                 By optionsLocator,
	                                 String value) {

	    dropdown.selectCustomDropdown(
	            dropdownLocator,
	            optionsLocator,
	            value);

	}

	// =====================================================
	// Alert Wrapper
	// =====================================================

	public void acceptAlert() {

	    alert.acceptAlert();

	}

	public void dismissAlert() {

	    alert.dismissAlert();

	}

	public String getAlertText() {

	    return alert.getAlertText();

	}

	public void sendAlertText(String text) {

	    alert.sendText(text);

	}

	public boolean isAlertPresent() {

	    return alert.isAlertPresent();

	}

	// =====================================================
	// Frame Wrapper
	// =====================================================

	public void switchToFrame(By locator) {

	    frame.switchToFrame(locator);

	}

	public void switchToFrame(int index) {

	    frame.switchToFrame(index);

	}

	public void switchToFrame(String nameOrId) {

	    frame.switchToFrame(nameOrId);

	}

	public void switchToDefaultContent() {

	    frame.switchToDefaultContent();

	}

	public void switchToParentFrame() {

	    frame.switchToParentFrame();

	}

	// =====================================================
	// Window Wrapper
	// =====================================================

	public String getCurrentWindow() {

	    return window.getCurrentWindow();

	}

	public void switchToLatestWindow() {

	    window.switchToLatestWindow();

	}

	public void switchToParentWindow(String parent) {

	    window.switchToParentWindow(parent);

	}

	public void closeCurrentWindow() {

	    window.closeCurrentWindow();

	}

	public int getWindowCount() {

	    return window.getWindowCount();

	}

	// =====================================================
	// Screenshot Wrapper
	// =====================================================

	public String captureScreenshot(String name) {

	    return screenshot.capture(name);

	}

	public String captureElementScreenshot(By locator,
	                                       String name) {

	    return screenshot.captureElement(locator, name);

	}

	// =====================================================
	// Upload File
	// =====================================================

	public void uploadFile(By locator,
	                       String filePath) {

	    wait.waitForVisibility(locator)
	            .sendKeys(filePath);

	}

	// =====================================================
	// Checkbox
	// =====================================================

	public void check(By locator) {

	    WebElement element =
	            wait.waitForClickable(locator);

	    if (!element.isSelected()) {

	        element.click();

	    }

	}

	public void uncheck(By locator) {

	    WebElement element =
	            wait.waitForClickable(locator);

	    if (element.isSelected()) {

	        element.click();

	    }

	}

	// =====================================================
	// Retry Click
	// =====================================================

	public void retryClick(By locator,
	                       int retryCount) {

	    for (int i = 0; i < retryCount; i++) {

	        try {

	            click(locator);

	            return;

	        }

	        catch (Exception e) {

	        }

	    }

	    throw new RuntimeException(
	            "Unable to click : " + locator);

	}

	// =====================================================
	// Dynamic Locator
	// =====================================================

	public By dynamicXpath(String xpath,
	                       String value) {

	    return By.xpath(
	            String.format(xpath, value));

	}

	// =====================================================
	// Generic Verification
	// =====================================================

	public boolean verifyText(By locator,
	                          String expected) {

	    return getText(locator)
	            .trim()
	            .equals(expected);

	}

	public boolean containsText(By locator,
	                            String expected) {

	    return getText(locator)
	            .contains(expected);

	}
}