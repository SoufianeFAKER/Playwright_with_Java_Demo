package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class XpathLocator {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();

		
		
		//Exemple 1
//		page.navigate("https://www.amazon.com/");
//		page.locator("xpath=//input[@id='twotabsearchtextbox']").fill("Macbook pro");
		//OR
//		page.locator("//input[@id='twotabsearchtextbox']").fill("Macbook pro");
		
		//Exemple 2
//		page.navigate("https://www.amazon.com/");
//		Locator totalAmazonLinks = page.locator("//a[contains(text(), 'Amazon')]");
//		System.out.println(totalAmazonLinks.count());
//		
//		totalAmazonLinks.allInnerTexts().forEach(e -> System.out.println(e));
		
		//Exemple 3 
		page.navigate("https://selectorshub.com/xpath-practice-page/");
//		page.locator("//a[text()='Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']")
//				.click();
		
		//Exemple 3.1
//		Locator checkboxes = page.locator("//table[@id='resultTable']//input[@type='checkbox']");
//		for(int i = 0; i < checkboxes.count(); i++) {
//			
//			checkboxes.nth(i).click();
//			
//		}
//		
		/*
		 * ----- Autres exemple ------
		 * (//table[@id='resultTable']//input[@type='checkbox'])[position()=2]
		 * (//table[@id='resultTable']//input[@type='checkbox'])[2]
		 * (//table[@id='resultTable']//input[@type='checkbox'])[last()]
		 */
		
		page.locator("(//table[@id='resultTable']//input[@type='checkbox'])[1]").click();
		page.locator("(//table[@id='resultTable']//input[@type='checkbox'])[last()]").click();
		

	}

}
