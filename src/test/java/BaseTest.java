import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    //Ovde pravimo metodu koja otvara chrome sa svim potrebnim opcijama
    public ChromeDriver openChromeDriver() {
        print("Openening Chrome Driver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--start-maximized"});
        options.addArguments(new String[]{"--ignore-certificate-errors"});
        options.addArguments(new String[]{"--disable-popup-blocking"});
        options.addArguments(new String[]{"--incognito"});
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        return driver;
    }

    //ovde je metoda koju mozemo da koristimo u svim testovima
    public void assertUrl(String actualUrl, String expectedUrl) {
        print("assertUrl (" + actualUrl + " , " + expectedUrl + " )");
        assert actualUrl.equals(expectedUrl) : "Wrong URL. Expected: " + expectedUrl + " . Actual: " + actualUrl;
    }


    public static void print(String s) {
        System.out.println(s);
    }

    public InventoryPage logWithValidUser(ChromeDriver driver) {
        print("1. Login as valid user");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterTextIntoUsernameField(Strings.STANDARD_USER);
        loginPage.enterTextIntoPasswordField(Strings.VALID_PASSWORD);
        InventoryPage inventoryPage = loginPage.clickLoginButtonSuccess();
        return inventoryPage;
    }

    public void logWithValidUserVoid(ChromeDriver driver) {
        print("1. Login as valid user");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterTextIntoUsernameField(Strings.STANDARD_USER);
        loginPage.enterTextIntoPasswordField(Strings.VALID_PASSWORD);
    }


}
