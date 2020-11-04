package internet_store.application.uiaction;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import internet_store.application.Product;
import internet_store.application.ProductDatabase;
import internet_store.application.ProductDatabaseImpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class FindByProductNameUIActionTest {

    ProductDatabase productDatabase = new ProductDatabaseImpl();
    private final ByteArrayInputStream inputNameToFind = new ByteArrayInputStream("Pineapple".getBytes());
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    Product product1 = new Product("PineApple", "Very good", new BigDecimal("5"));
    Product product2 = new Product("Orange", "Sweet", new BigDecimal("2"));
    Product product3 = new Product("PINEAPPLE", "Bad", new BigDecimal("1"));

    @Test
    public void ShouldFindTwoProductsWithSameName () {

        productDatabase.save(product1);
        productDatabase.save(product2);
        productDatabase.save(product3);

        List<Product> testList = new ArrayList<>(productDatabase.findByProductName("Pineapple"));
        assertTrue(testList.get(0).equals(product1));
        assertTrue(testList.get(1).equals(product3));
        assertTrue(testList.size() == 2);
    }

    @Test
    public void ShouldFindNoProducts () {

        productDatabase.save(product1);
        productDatabase.save(product2);

        List<Product> testList = new ArrayList<>(productDatabase.findByProductName("Coconut"));
        assertTrue(testList.isEmpty());
    }

    @Before
    public void setUp() {
        System.setIn(inputNameToFind);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setIn(System.in);
        System.setOut(standardOut);
    }

    @Test
    public void ShouldFindNoProductsViaUIAction () {
        productDatabase.save(product2);

        FindByProductNameUIAction testFind = new FindByProductNameUIAction(productDatabase);
        testFind.execute();

        assertEquals(
                "Enter product name to search for: \n"
                        + "No product with name = Pineapple in the database"
                        ,outputStreamCaptor.toString().trim());
    }

}

