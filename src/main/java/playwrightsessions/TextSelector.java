package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextSelector {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
//		page.navigate("https://www.orangehrm.com/en/30-day-free-trial/");
		
		// (1) Text Locators
//		page.locator("text = Resources").first().click();
		
		// (2) Text Locators
		// Exemple 1
//		page.locator("text=Privacy Policy").first().click();
		
		// Exemple 2
//		Locator links = page.locator("text=Privacy Policy");
//		
//		for(int i = 0; i < links.count(); i++) {
//			
//			String text = links.nth(i).textContent();
//			if(text.contains("Service Privacy Policy")) {
//				
//				links.nth(i).click();
//				break;
//				
//			}
//			
//		}
		
		// Exemple 3
		page.navigate("https://demo.opencart.com/index.php?route=account/login");
		
		String header = page.locator("div.card-body h2:has-text('New Customer')").textContent();
		System.out.println(header);
		
		String menuDesktops = page.locator("'Desktops'").textContent(); // this is equal to this
		String menuDesktops2 = page.locator("text='Desktops'").textContent();
		
		System.out.println(menuDesktops);
		System.out.println(menuDesktops2);
		
		// button
		page.locator("form button:has-text('Login')").click();

	}

}
