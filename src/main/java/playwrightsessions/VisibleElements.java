package playwrightsessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VisibleElements {
	
public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		
		// ***************** Apply Filter *****************
		//button:visible
		//button >> visible=true
		
		// First exemple in Local page html
//
//		page.navigate("http://127.0.0.1/main/index.html");
////		String text = page.locator("button:visible").textContent();
//		String text = page.locator("button >> visible=true").textContent();
//		
//		System.out.println(text);
		
		
		
		page.navigate("https://www.amazon.com/");
		
		//Search all tag a and is visible
		List<String> linksText = page.locator("a:visible").allInnerTexts();
		
		for(int i=0; i<linksText.size(); i++) {
			
			System.out.println(linksText.get(i));
			
		}
		
		//Search all tag img with XPATH and is visible
		int imagesCount = page.locator("xpath=//img >> visible=true").count();
		System.out.println(imagesCount);
		
		//text=Login >> visible=true

	}


}
