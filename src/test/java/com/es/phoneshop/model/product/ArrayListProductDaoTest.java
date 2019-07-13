package com.es.phoneshop.model.product;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.*;

public class ArrayListProductDaoTest
{
    private ProductDao productDao;

    @Before
    public void setup() {
        productDao = new ArrayListProductDao();
    }

    @Test
    public void testFindProducts() {
        Long id = 4L;
        productDao.save(new Product(id, "nokia", "Nokia",
                new BigDecimal(10), Currency.getInstance(Locale.US), 100));
        List<Product> productList = productDao.findProducts();
        assertFalse(productList.isEmpty());

    }

    @Test
    public void testGetProduct() {
        Long id = 3L;
        productDao.save(new Product(id, "nokia", "Nokia",
                    new BigDecimal(10), Currency.getInstance(Locale.US), 100));
        Product product = productDao.getProduct(id);
        assertEquals(id, product.getId());
    }

    @Test
    public void testSave() {
        Long id = 3L;
        productDao.save(new Product(id, "nokia", "Nokia",
                new BigDecimal(10), Currency.getInstance(Locale.US), 100));
        Product product = productDao.getProduct(id);
        assertNotNull(product);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNotFound() {
        productDao.delete(1L);
    }


}
