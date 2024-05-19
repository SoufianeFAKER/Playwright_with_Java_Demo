package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CommaSelectors {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		
		page.navigate("https://academy.naveenautomationlabs.com/");
		
		// Exemple 1
		page.locator("a:has-text('SignIn'), "
				+ "a:has-text('LogIn'), "
				+ "a:has-text('Login'), "
				+ "a:has-text('Signin')").click();
		
		// Exemple 2
		Locator imp_ele = page.locator("a:has-text('Login'),"
				+ " a:has-text('Courses'), "
				+ "button:has-text('SUBMIT')");
		
		System.out.println(imp_ele.count());
		
		if(imp_ele.count() == 4 ) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		
		// Exemple 3
		Locator login = page.locator("//a[text()='Login'] | //a[text()='login']");
		System.out.println(login.textContent());
		login.click();

	}

}
