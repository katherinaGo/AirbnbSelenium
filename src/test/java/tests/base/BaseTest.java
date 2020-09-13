package tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.LoginPage;
import pages.ProfilePage;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;

//@Listeners(TestListener.class)
public class BaseTest {

    protected static WebDriver driver;
    protected LoginPage loginPage;
    protected ProfilePage profilePage;

    @BeforeMethod
    public void SetUp() {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
//        System.setProperty("webdriver.gecko.driver", "src/test/resources/webdrivers/geckodriver");
//        FirefoxProfile profile = new FirefoxProfile();
//        profile.setPreference("intl.accept_languages", "en-USA");
//        FirefoxOptions options = new FirefoxOptions();
//        options.setProfile(profile);
//        driver = new FirefoxDriver(options);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
