package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FillFormUsingRelativeLocators {
	
	static Page page;
	
	public static void main(String[] args) {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		page = browser.newPage();

		page.navigate("https://www.orangehrm.com/30-day-free-trial/");
		
		page.locator("input#Form_getForm_Name:below(label:text('FullName'))").first().fill("Hiba Faker");
		page.locator("input#Form_getForm_Email:below(label:text('Email'))").first().fill("hiba.faker@gmail.com");
		page.locator("input#Form_getForm_Contact:below(label:text('Email'))").first().fill("22 56 98 47");
		
	}

}
