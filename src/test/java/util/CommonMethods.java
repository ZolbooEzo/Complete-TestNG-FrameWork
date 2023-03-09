package util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

public class CommonMethods extends PageInitializer {

	public static String getTimeStamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		return sdf.format(date.getTime());
	}

	public static byte[] takeScreenshot(String fileName) {
		TakesScreenshot ts = (TakesScreenshot) BaseClass.getDriver();

		byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
		File file = ts.getScreenshotAs(OutputType.FILE);

		String destinationFile = Constants.screenshotPath + fileName + getTimeStamp() + ".png";

		try {
			FileUtils.copyFile(file, new File(destinationFile));
		} catch (Exception ex) {
			System.out.println("Can't take screen shot!");
		}

		return picBytes;

	}

	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	// Click radio button or check box by attribute
	// -------------------------------------------------------------------------------------

	public static void clickRadioOrCheckBox(List<WebElement> radioOrCheckBox, String value) {
		String actualValue;
		for (WebElement element : radioOrCheckBox) {
			actualValue = element.getAttribute("value").trim();
			if (actualValue.equalsIgnoreCase(value)) {
				element.click();
				break;
			}
		}
	}

	// Click radio button or check box by
	// getText-------------------------------------------------------------------------------------

	public static void clickRadioOrCheckBoxGetText(List<WebElement> radioOrCheckBox, String value) {
		String actualValue;
		for (WebElement element : radioOrCheckBox) {
			actualValue = element.getText().trim();
			if (actualValue.equalsIgnoreCase(value)) {
				element.click();
				break;
			}
		}
	}

	// Select drop down by
	// value-------------------------------------------------------------------------------------
	public static void selectOptionsByValue(WebElement element, String text) {
		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			for (WebElement el : options) {
				if (el.getText().equals(text)) {
					select.selectByValue(text);
					break;
				}
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	// Select drop down by index
	// -------------------------------------------------------------------------------------

	public static void selectOptionsByIndex(WebElement element, int index) {
		try {
			Select select = new Select(element);
			int size = select.getOptions().size();
			if (size > index) {
				select.selectByIndex(index);
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	// Select drop down by visible
	// Text-------------------------------------------------------------------------------------

	public static void selectOptionsByVisibleText(WebElement element, String text) {
		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			for (WebElement el : options) {
				if (el.getText().equals(text)) {
					select.selectByVisibleText(text);
					break;
				}
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	// Dismiss
	// alert-------------------------------------------------------------------------------------

	public static void dismissAlert() {
		try {
			Alert alert = BaseClass.getDriver().switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	// close alert or
	// accept-------------------------------------------------------------------------------------

	public static void acceptAlert() {
		try {
			Alert alert = BaseClass.getDriver().switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	// Get alert
	// message-------------------------------------------------------------------------------------

	public static String getAlertText() {
		String alertText = null;
		try {
			Alert alert = BaseClass.getDriver().switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		return alertText;
	}

	// send text to
	// alert-------------------------------------------------------------------------------------

	public static void alertSendText(WebElement element, String str) {
		try {
			Alert alert = BaseClass.getDriver().switchTo().alert();
			alert.sendKeys(str);
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	// switch to frame using name or
	// id-------------------------------------------------------------------------------------

	public static void switchToIFrame(String str) {
		try {
			BaseClass.getDriver().switchTo().frame(str);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	// switch to frame using
	// index-------------------------------------------------------------------------------------

	public static void switchToIFrame(int index) {
		try {
			BaseClass.getDriver().switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	// switch to frame using
	// webElement-------------------------------------------------------------------------------------

	public static void switchToIFrame(WebElement element) {
		try {
			BaseClass.getDriver().switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	// declaring and initializing js object and returning
	// it-------------------------------------------------------------------------------------

	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
		return js;
	}

	// java script click
	// element-------------------------------------------------------------------------------------

	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click()", element);
	}

	// javascript sends
	// text-------------------------------------------------------------------------------------

	public static void jsSentText(WebElement element, String text) {
		String valueText = element.getAttribute("value");
		getJSObject().executeScript("arguments[0].value='" + valueText + "'", text);
	}

	// scroll to element using
	// js-------------------------------------------------------------------------------------

	public static void scrollToElement(WebElement element) {
		getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// scroll by
	// pixel-------------------------------------------------------------------------------------

	public static void ScrolByPixel(int pixel) {
		// positive -- scroll down
		// negative -- scroll up
		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
	}

	// thread .slee is
	// simplified-------------------------------------------------------------------------------------

	public static void wait2(int seconds) {

		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// hover over == moving your curser on an
	// element-------------------------------------------------------------------------------------

	public static void hover(WebElement element) {
		Actions actions = new Actions(BaseClass.getDriver());
		actions.moveToElement(element).build().perform();
	}

	// create a method that
	// dragsAndDrops-------------------------------------------------------------------------------------

	public static void dragsAndDrops(WebElement element, WebElement element2) {
		Actions action = new Actions(BaseClass.getDriver());
		action.dragAndDrop(element, element2).build().perform();
	}

	// create a method that
	// doubleClicks-------------------------------------------------------------------------------------

	public static void doubleClicks(WebElement element) {
		Actions action = new Actions(BaseClass.getDriver());
		action.doubleClick(element).build().perform();
	}

	// calendar select
	// date-------------------------------------------------------------------------------------

	public static void selectCalendarDate(List<WebElement> element, String text) {
		for (WebElement pickDate : element) {
			if (pickDate.isEnabled()) {
				if (pickDate.getText().equals(text)) {
					pickDate.click();
					break;
				}
			}
		}
	}

	/**
	 * return a list of string from a list of elements ignores any element with no
	 * text
	 * 
	 * @param list
	 * @return
	 */
	public static List<String> getElementsText(List<WebElement> list) {
		List<String> elemTexts = new ArrayList<String>();
		for (WebElement el : list) {
			if (!el.getText().isEmpty()) {
				elemTexts.add(el.getText());
			}
		}
		return elemTexts;
	}

}
