import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    //potrebno nam je da Page klasa ima atribut Chromedriver
    ChromeDriver driver = null;


    //Webelementi

    @FindBy(id = "user-name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    //konstruktor
    public LoginPage(ChromeDriver driver) {
        driver.get(Strings.LOGIN_URL);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //metoda za upisivanje usernamea
    public LoginPage enterTextIntoUsernameField(String username) {
        usernameField.sendKeys(username);
        return this;
    }

    public LoginPage enterTextIntoPasswordField(String pass) {
        passwordField.sendKeys(pass);
        return this;
    }

    //metoda koja klikce ne Login dugme i prebacuje nas na Inventory stranu
    public InventoryPage clickLoginButtonSuccess() {
        loginButton.click();
        //zbog prakticnih razloga , ovde pravimo objekat nove stranice i njega vracamo
        InventoryPage inventoryPage = new InventoryPage(driver);
        return inventoryPage;
    }

    //ova metoda ocekuje da , kada kliknemo, se ne ulogujemo na aplikaciju jer su pogresni kredencijali
    public LoginPage clickLoginButtonFailure() {
        loginButton.click();
        return this;
    }

}
