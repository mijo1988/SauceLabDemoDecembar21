import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{


    //Pre svakog testa dodati test case
    @Test
    public void loginWithValidCredentils() {
        ChromeDriver driver = openChromeDriver();
        try {
            LoginPage loginPage = new LoginPage(driver);

            //kada metoda je void onda ih ovako nizemo
//            loginPage.enterTextIntoUsernameField(Strings.STANDARD_USER);
//            loginPage.enterTextIntoPasswordField(Strings.VALID_PASSWORD);
//            loginPage.clickLoginButtonSuccess();

            //kada metoda vraca LoginPage i radimo return this, onda mozemo ovako da ih nizemo
            loginPage.enterTextIntoPasswordField(Strings.STANDARD_USER)
                    .enterTextIntoPasswordField(Strings.VALID_PASSWORD)
                    .clickLoginButtonSuccess();
            
//            assert driver.getCurrentUrl().equals(Strings.INVENTORY_URL): "Wrong URL";
            //koristimo metodu za uporedjivanje trenutnog i ocekivanog urla
            assertUrl(driver.getCurrentUrl() , Strings.INVENTORY_URL);
        } finally {
            driver.quit();
        }
    }


    @Test
    public void loginWithInvalidUserNameANdValidPass() {
        ChromeDriver driver = openChromeDriver();
        try {
            LoginPage loginPage = new LoginPage(driver);

            print("Entering invalid username");
            loginPage.enterTextIntoUsernameField(Strings.INVALID_USER);
            print("Entering valid password");
            loginPage.enterTextIntoPasswordField(Strings.VALID_PASSWORD);
            print("Clicking LOgin button");
            loginPage.clickLoginButtonFailure();

            assertUrl(driver.getCurrentUrl() , Strings.LOGIN_URL);
        } finally {
            driver.quit();
        }
    }



}
