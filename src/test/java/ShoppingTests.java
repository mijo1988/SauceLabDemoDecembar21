import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShoppingTests extends BaseTest{


    /**
     * Add an item from Inventory Page
     *
     * Steps:
     * 1. Login as valid user
     * 2. From inventory page click on 'Add to cart' button for one item
     *
     * Expected results
     * 2. Verify that shopping cart icon has number 1 on it
     */
    @Test
    public void addOneItemInShoppingTest() {
        ChromeDriver driver = openChromeDriver();
        try {
            //koristimo metodu koja nas uvek uloguje sa validnim userom
            InventoryPage inventoryPage = logWithValidUser(driver);
//            print("1. Login as valid user");
//            LoginPage loginPage = new LoginPage(driver);
//            loginPage.enterTextIntoUsernameField(Strings.STANDARD_USER)
//                    .enterTextIntoPasswordField(Strings.VALID_PASSWORD);
//            InventoryPage inventoryPage = loginPage.clickLoginButtonSuccess();

            print("2. From inventory page click on 'Add to cart' button for one item");
            inventoryPage.clickAddToCartBackpack();

            print("2. Verify that shopping cart icon has number 1 on it");
            String currentNumber = inventoryPage.getNumberFromShoppingCartIcon();
            assert currentNumber.equals("1") : "Wrong number of items. Expected :1 . Actual: " + currentNumber;

        } finally {
            driver.quit();
        }
    }


    /**
     * Add and remove item from Inventory Page
     *
     * Steps:
     * 1. Login as valid user
     * 2. From inventory page click on 'Add to cart' button for one item
     * 3. Click on 'Remove' button
     *
     * Expected results
     * 2. Verify that shopping cart icon has number 1 on it
     * 3. Verify that shopping cart icon does not have any number on it
     */
    @Test
    public void addAndRemoveOneItemFromInventoryPage() {
        ChromeDriver driver = openChromeDriver();
        try {

//            InventoryPage inventoryPage = logWithValidUser(driver);

            //ova metoda vraca void umesto InventoryPage objekata
            //onda moramo da kreiramo objekat InventoryPage-a
            logWithValidUserVoid(driver);
            InventoryPage inventoryPage = new InventoryPage(driver);

            print("2. From inventory page click on 'Add to cart' button for one item");
            inventoryPage.clickAddToCartBackpack();

            print("2. Verify that shopping cart icon has number 1 on it");
            String currentNumber = inventoryPage.getNumberFromShoppingCartIcon();
            assert currentNumber.equals("1") : "Wrong number of items. Expected :1 . Actual: " + currentNumber;

            print("Click on 'Remove' button");
            inventoryPage.clickRemoveBackpack();

            print("3. Verify that shopping cart icon does not have any number on it");
            //ovo cemo nastaviti sledeci cas
//            currentNumber = inventoryPage.getNumberFromShoppingCartIcon();


        } finally {
            driver.quit();
        }
    }



}
