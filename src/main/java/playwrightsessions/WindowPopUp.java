package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindowPopUp {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext bx1 = browser.newContext();
		BrowserContext bx2 = browser.newContext();

		Page page1 = bx1.newPage();
//		Page page2 = bx2.newPage();
//		
//		page1.navigate("https://www.google.com");
//		page2.navigate("https://www.amazon.com");
		
		page1.navigate("https://opensource-demo.orangehrmlive.com/");
		
		
		/* --- Open a new tab/window/popup after clicking on link on the parent page --- */
		
		Page popup = page1.waitForPopup(() -> {
			
			page1.click("//a[@href='https://twitter.com/orangehrm?lang=en']");
			
			
		});
		
		popup.waitForLoadState();
		
		System.out.println("pop up window title: " + popup.title());
		
		popup.close();
		
		System.out.println("parent window title: " + page1.title());
		
		page1.close();
		bx1.close();
		playwright.close();
		
		/* ------ Open a new blank tab/window popup and enter the new url:
		Page popup = page1.waitForPopup(() -> {
			
			page1.click("a[target='_blank']");	//open a new tab window
			
		});
		
		popup.waitForLoadState();
		popup.navigate("https://www.google.com");
		System.out.println("pop up window title: " + popup.title());
		popup.close();
		System.out.println("parent window title: " + page1.title());
		page1.close();
		*/

	}

}
