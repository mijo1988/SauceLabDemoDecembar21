import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SortingTests extends BaseTest {



    @Test
    public void sortPriceLowToHigh() {
        ChromeDriver driver = new ChromeDriver();
        try {
            InventoryPage inventoryPage = logWithValidUser(driver);

            //Ova metoda dohvata prvi item sa stranice i njegovu cenu sa sve $ ispred
            String priceBeforeSortingText = inventoryPage.getFIrstItemFromInventoryPage();

            //ovom metodom odsecamo $
            String justPriceBeforeSorting= priceBeforeSortingText.substring(1);
            //ovom metodom pretvaramo string u double
            double priceBeforeSortingDouble = Double.valueOf(justPriceBeforeSorting);

            //koristomo sort
            inventoryPage.selectLowToHighSort();

            //isto kao i gore, dohvatamo prvi item i njegovu cenu
            String priceAfterSortingText = inventoryPage.getFIrstItemFromInventoryPage();
            String justPriceAfterSorting= priceAfterSortingText.substring(1);
            double priceAfterSortingDouble = Double.valueOf(justPriceAfterSorting);

            //ovde dodajte metodu za uporedjivanje


        }finally {
//            driver.quit();
        }


    }
}
