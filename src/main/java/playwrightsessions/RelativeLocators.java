package playwrightsessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RelativeLocators {

	static Page page;

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		page = browser.newPage();

		page.navigate("https://selectorshub.com/xpath-practice-page/");

		selectUser("Joe.Root");
		selectUser("Jasmine.Morgan");

		String userRole = getUserRole("Joe.Root");
		System.out.println(userRole);
		
		String aboveUser = page.locator("a:above(:text('Joe.Root'))").first().textContent();
		System.out.println(aboveUser);
		
		String belowUser = page.locator("a:below(:text('Joe.Root'))").first().textContent();
		System.out.println(belowUser);
		
		Locator nearElements = page.locator("td:near(:text('Joe.Root'), 400)");
		List<String> nearElemText = nearElements.allInnerTexts();
		for(String e : nearElemText) {
			
			System.out.println(e);
			
		}

	}

	public static void selectUser(String userName) {

		page.locator("input[type='checkbox']:left-of(:text('" + userName + "'))").first().click();

	}

	public static String getUserRole(String userName) {

		return page.locator("td:right-of(:text('" + userName + "'))").first().textContent();

	}

}
