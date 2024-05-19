package playwrightsessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ReactElement {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();

		page.navigate("https://www.netflix.com/tn-fr/");
		
		//Exemple 1
//		Locator email = page.locator("_react=Anonymous[name='email'] >> input").first();
//		email.click();
//		email.fill("zoro@gmail.com");
		
		//Exemple 2
//		page.locator("_react=Anonymous[data-uia='language-picker-header']").click();
		
		//Exemple 3
		Locator footer = page.locator("_react=Anonymous[data-uia='footer-link']");
		List<String> footerList = footer.allInnerTexts();
		
		// ---> 1st Loop
//		footerList.forEach(e -> System.out.println(e));
		
		// ---> End Loop
//		for(String e : footerList) {
//			
//			System.out.println(e);
//			
//		}
		// ---> with stream
		footer.allInnerTexts().stream().forEach(e -> System.out.println(e));
		

	}

}
