package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NthElementSelector {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page   page = browser.newPage();

		page.navigate("https://www.bigbasket.com/");
		
		Locator first_elem = page.locator("footer > div.container li a >> nth=0");
		String firstEle = first_elem.textContent();
		System.out.println(firstEle);
		//first_elem.click();
		
		Locator last_elem = page.locator("footer > div.container li a >> nth=-1");
		String lastEle = last_elem.textContent();
		System.out.println(lastEle);

	}

}
