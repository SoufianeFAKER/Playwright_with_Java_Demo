package playwrightsessions;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VideoRecording {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext browserContext = browser.newContext(
				new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myvideos/")).setRecordVideoSize(640, 480));

		Page page = browserContext.newPage();

		// Go to https://academy.naveenautomationlabs.com/
		page.navigate("https://academy.naveenautomationlabs.com/");

		// Click text=Login
		page.click("text=Login");

		// Click strong:has-text('Sign up')
		// page.click("strong:has-text('Sign up')");

		page.frameLocator("//iframe[contains(@id, 'microfe-popup-login')]").locator("strong:has-text('Sign up')")
				.click();

		// Click And Fill field Name
		page.frameLocator("//iframe[contains(@id, 'microfe-popup-login')]").locator("#input-fname")
				.fill("testing automation");

		// Click And Fill field Email
		page.frameLocator("//iframe[contains(@id, 'microfe-popup-login')]").locator("#input-email")
				.fill("testing@gmail.com");

		// Click And Fill field password
		page.frameLocator("//iframe[contains(@id, 'microfe-popup-login')]").locator("#input-password").fill("12345");

		// Not forget to close the browser context == Not Record the Video for you
		browserContext.close();
		page.close();
		playwright.close();

	}

}
