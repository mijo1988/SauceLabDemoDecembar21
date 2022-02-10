import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    //potrebno nam je da Page klasa ima atribut Chromedriver
    ChromeDriver driver = null;

    //webelementi koji su zajednicki za sve strane

    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCartLink;

    @FindBy(className = "shopping_cart_badge")
    WebElement shoppingCartBadgeNumber;



    //konstrukotor nadklase
    public BasePage(ChromeDriver driver) {
        //PageFactory.initElements je metoda koja instancira sve webelemente koje smo kreirali pomocu @FindBy
        PageFactory.initElements(driver, this);
        //ovako setujemo da driver prosledjen kao paramter konstruktoru bude koriscen
        this.driver = driver;
    }

    //metoda za kliktanje na shopping cart ikonu i navigaciju ka shopping cart strani
    public CartPage clickOnShoppingCartIcon() {
        shoppingCartLink.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

    //metoda koja dohvata broj iz shopping cart ikone
    public String getNumberFromShoppingCartIcon() {
        String number = shoppingCartBadgeNumber.getText();
        return number;
    }


}
