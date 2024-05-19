package playwrightsessions;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

public class FileUploadHandle {

	public static void main(String[] args) throws InterruptedException {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();

		// input type = file

//		page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");

		// Exemple 1 --- Select one File:
//		page.setInputFiles("input#filesToUpload", Paths.get("applogin.json"));
//
//		// DesSelected a file
//		page.setInputFiles("input#filesToUpload", new Path[0]);

		// Exemple 2 --- Select multiple File

//		page.setInputFiles("input#filesToUpload",
//				new Path[] { 
//						Paths.get("applogin.json"), 
//						Paths.get("pom.xml"), 
//						Paths.get("trace.zip") 
//						});
//		Thread.sleep(3000);
//		page.setInputFiles("input#filesToUpload", new Path[0]);

		// Exemple 3 --- Run time file --> Upload
//		page.setInputFiles("input#filesToUpload",
//				new FilePayload("test.txt", "text/plain", "This is QA Tester Here".getBytes(StandardCharsets.UTF_8)));

		// Exemple 4 --- Run time File And View Content
		
		page.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		page.setInputFiles("//input[@name='upfile']",
				new FilePayload("test.txt", "text/plain", "This is QA Tester Here".getBytes(StandardCharsets.UTF_8)));
		
		page.click("input[type='submit']");

		
	}

}
