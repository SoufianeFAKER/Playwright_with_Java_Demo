package playwrightsessions;

import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class Example {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      
   // Start tracing before creating / navigating a page.
      context.tracing().start(new Tracing.StartOptions()
        .setScreenshots(true)
        .setSnapshots(true)
        .setSources(true));
      
      Page page = context.newPage();
      page.navigate("https://academy.naveenautomationlabs.com/");
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
      page.frameLocator("#microfe-popup-login").getByText("Sign up").click();
      
     // page.pause();
      
      
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").click();
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").fill("Soufiane FAKER");
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").click();
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").fill("sfaker@yahoo.fr");
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").click();
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").fill("Soufien12345");
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Enter your number").click();
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Enter your number").fill("+216 975 641 44");
      page.frameLocator("#microfe-popup-login").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Next")).click();
      
   // Stop tracing and export it into a zip archive.
      context.tracing().stop(new Tracing.StopOptions()
        .setPath(Paths.get("trace.zip")));
    }
  }
}
