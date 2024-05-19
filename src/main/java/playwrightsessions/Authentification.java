package playwrightsessions;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Authentification {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brContext = browser.newContext();

		Page page = brContext.newPage();

		page.navigate("https://www.automationpractice.pl");
		
		page.click("a:text('Sign in')");
		page.fill("#email", "sfaker@yahoo.fr");
		page.fill("#passwd", "12345");
		page.click("#SubmitLogin");
		
		brContext
			.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));

	}

}
