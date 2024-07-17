package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductSearchPage;

public class ProductSearchTest extends BaseTest {

@Test (priority = 3)

    public void productPurchase() {

        ProductSearchPage productSearchPage = new ProductSearchPage(driver);

        productSearchPage.productSearch();

    Assert.assertTrue(productSearchPage.isCheckoutPageDisplayed(), "The checkout page is not displayed after clicking on checkout button");
    }
}
