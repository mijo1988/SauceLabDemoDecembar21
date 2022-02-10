import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class InventoryPage extends BasePage {

    //webelements
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartBackpackButton;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement addToCartBikeLightButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeBackpackButton;

    @FindBy(className = "product_sort_container")
    WebElement sortDropDown;

    //sve podklase samo nasledjuju konstruktor nadklase
    //konstruktor
    public InventoryPage(ChromeDriver driver) {
        super(driver);
    }

    //metode u Inventory page-u

    //metoda koja klikce na add to cart za backpack
    public InventoryPage clickAddToCartBackpack() {
        addToCartBackpackButton.click();
        return this;
    }

    //isto samo za ranac
    public InventoryPage clickAddToCartBikeLight() {
        addToCartBikeLightButton.click();
        return this;
    }

    //metoda koja klikce na Remove za backpack
    public InventoryPage clickRemoveBackpack() {
        removeBackpackButton.click();
        return this;
    }

    //metoda za biranje opcije za sortiranje itema
    public InventoryPage selectLowToHighSort() {

        //Select je klasa za upravljanje dropdown-ovima
        Select dropdown = new Select(sortDropDown);
        //ovako se bira opcija iz dropdowna po tekstu koji pise
        dropdown.selectByVisibleText("Price (low to high)");
        return this;
    }

    //ovo je univerzalna metoda za trazenje cene bilo kog itema po njegovom nazivu
    public String getItemPrice(String itemName) {
        String price = null;
        //ovako dohvatamo sve divove sa itemima
        List<WebElement> allItems = driver.findElements(By.className("inventory_item"));
        for(WebElement element : allItems) {
            //ovako iz tog niza svih itema trazimo onaj koji sadrzi ime tog itema
            if(element.getText().contains(itemName)) {
                //kada nadjemo taj item onda nad tim webelementom trazimo webelement koji sadrzi cenu
                WebElement priceWebElement = element.findElement(By.className("inventory_item_price"));
                //i dohvatamo tekst koji sadrzi cenu
                price = priceWebElement.getText();
                break;
            }
        }
        return price;
    }


    //ova metoda dohvata cenu prvog itema
    public String getFIrstItemFromInventoryPage() {
        String price = null;
        //dohvatamo sve iteme i stavljamo u niz
        List<WebElement> allItems = driver.findElements(By.className("inventory_item"));
        //i dohvatamo webelement sa cenom prvog itema u nizu
        WebElement firstElementPrice = allItems.get(0).findElement(By.className("inventory_item_price"));
        return firstElementPrice.getText();
    }

}
