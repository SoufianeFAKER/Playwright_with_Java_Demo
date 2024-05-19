package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class JsPopUpHandle {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();

		// Listener
		page.onDialog(dialog -> {

			String text = dialog.message();
			System.out.println(text);
			// dialog.accept();
			// dialog.dismiss();
			dialog.accept("Are you Sure?");

		});

		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

		// JS Alerts, Prompt, COnfirlation pop ups
		// -1--- Alert

//		page.click("//button[text()='Click for JS Alert']");
//		
//		String result = page.textContent("#result");
//		System.out.println(result);

		// -2--- Confirm

//		page.click("//button[text()='Click for JS Confirm']");
//
//		String result2 = page.textContent("#result");
//		System.out.println(result2);

		// -3--- Prompt

		page.click("//button[text()='Click for JS Prompt']");

		String result3 = page.textContent("#result");
		System.out.println(result3);

		page.close();
		browser.close();
		playwright.close();

	}

}
