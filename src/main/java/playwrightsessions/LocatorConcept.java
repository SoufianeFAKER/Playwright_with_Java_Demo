package playwrightsessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatorConcept {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		

		// Single Element
//		page.navigate("https://www.orangehrm.com/en/30-day-free-trial/");
//
//		Locator contactSales = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Contact Sales"));
//
//		contactSales.hover();
//		contactSales.click();
		
		// ==> Multiple Elements
//		page.navigate("https://academy.naveenautomationlabs.com/");
//		Locator loginBtn = page.locator("text = Login").first();
//		loginBtn.hover();
//		loginBtn.click();
		
		// ==> Multiple Elements
		page.navigate("https://www.orangehrm.com/en/30-day-free-trial/");
		
		Locator countryOptions = page.locator("select#Form_getForm_Country option");
		System.out.println(countryOptions.count());
		
//		Première Méthode de récupérer les elements
		
//		for(int i = 0; i<countryOptions.count(); i++) {
//			
//			String text = countryOptions.nth(i).textContent();
//			System.out.println(text);
//			
//		}
		
//		Deuxième Méthode de récupérer les elements
		
		List<String> optionsTextList =  countryOptions.allTextContents();
		
//		for(String e : optionsTextList) {
//			
//			System.out.println(e);
//			
//		}
		
		// avec lambda function
		optionsTextList.forEach(ele -> System.out.println(ele));
		
		
		page.close();

	}

}
