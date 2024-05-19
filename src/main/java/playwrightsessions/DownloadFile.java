package playwrightsessions;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DownloadFile {
	
	public static void main(String[] args) {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		
		Download download = page.waitForDownload(() -> {
			
			page.click("a:text('chromedriver_mac64.zip')");
			
		});
		
		//download.cancel();
		
		System.out.println(download.failure());
		
		System.out.println(download.url());
		System.out.println(download.page().title());
		
		//Get the temporary path
		String path = download.path().toString();
		System.out.println(path);
		
		//Change the path Directory
		download.saveAs(Paths.get("c:\\...\\Naveen_chrome.zip"));
		
		//return the file name
		System.out.println(download.suggestedFilename());
		
	}

}
