package com.es.phoneshop.model.product;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ArrayListProductDaoTest {

    @Mock
    private Product productFirst;

    private ProductDao productDao;

    @Before
    public void setup() {
        productDao = new ArrayListProductDao();
        when(productFirst.getId()).thenReturn(10L);
    }

    @Test
    public void testFindProducts() {
        List<Product> productList = productDao.findProducts();
        assertFalse(productList.isEmpty());
    }

    @Test
    public void testGetProduct() {
        Long id = 5L;
        assertEquals(id, productDao.getProduct(id).getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetProductIllegalArgumentException() {
        productDao.getProduct(-5L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaveIllegalArgumentException() {
        productDao.save(productFirst);
    }

    @Test
    public void testDelete() {
        int sizeBefore = productDao.findProducts().size();
        productDao.delete(5L);
        List<Product> productList = productDao.findProducts();
        assertEquals(sizeBefore - 1, productList.size());
    }
}
