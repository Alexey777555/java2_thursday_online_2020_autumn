package lesson_3.core.service.add_product.product_items_service;


import lesson_3.core.request.add_product.product_items.AddProductDescriptionRequest;
import lesson_3.core.response.add_product.product_items.AddProductDescriptionResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddProductDescriptionServiceTest {
    AddProductDescriptionService service = new AddProductDescriptionService();

    @Test
    public void shouldReturnCurrentString() {
        AddProductDescriptionRequest request = new AddProductDescriptionRequest("description");
        AddProductDescriptionResponse response = service.execute(request);
        assertEquals("description", response.getProductDescription());
    }

    @Test
    public void shouldReturnError_1() {
        AddProductDescriptionRequest request = new AddProductDescriptionRequest("");
        AddProductDescriptionResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals("Empty field", response.getErrors().get(0).getMessage());
    }

    @Test
    public void shouldReturnError_2() {
        AddProductDescriptionRequest request = new AddProductDescriptionRequest(null);
        AddProductDescriptionResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals("Empty field", response.getErrors().get(0).getMessage());
    }
}