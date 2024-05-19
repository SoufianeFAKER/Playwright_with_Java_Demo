package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBasics {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("msedge");
		lp.setHeadless(false);
		
		Browser browser = playwright.chromium().launch(lp);
		Page page = browser.newPage();
		page.navigate("https://www.amazon.com");
		
		String title = page.title();
		System.out.println("page title is : " + title);
		
		String url = page.url();
		System.out.println("url is : " + url);
		
		browser.close();
		playwright.close();

	}

}
