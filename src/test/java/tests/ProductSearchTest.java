package tests;

import org.testng.annotations.Test;
import pages.ProductSearchPage;

public class ProductSearchTest extends BaseTest {

@Test
    public void productPurchase() {

        ProductSearchPage productSearchPage = new ProductSearchPage(driver);

        productSearchPage.productSearch();

    }
}
