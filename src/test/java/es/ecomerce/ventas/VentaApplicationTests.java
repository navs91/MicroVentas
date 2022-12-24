package es.ecomerce.ventas;

import es.ecomerce.ventas.entity.Price;
import es.ecomerce.ventas.service.VentaServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.sql.Timestamp;
import java.util.Calendar;

@SpringBootTest
class VentaApplicationTests {

    @Autowired
    VentaServiceImpl ventaService;

    Calendar date = Calendar.getInstance();
    long productId = 35455;
    Price priceReturn;

    @BeforeEach
    void prepareTest() {
        priceReturn = null;
        date = Calendar.getInstance();
    }
    @Test
    void test_1() {
        date.set( 2020, 5, 14, 10, 0,0 );
    }

    @Test
    void test_2() {
        date.set( 2020, 5, 14, 16, 0,0 );
    }

    @Test
    void test_3() {
        date.set( 2020, 5, 14, 21, 0,0 );
    }

    @Test
    void test_4() {
        date.set( 2020, 5, 15, 10, 0,0 );
    }

    @Test
    void test_5() {
        date.set( 2020, 5, 16, 21, 0,0 );
    }
    @AfterEach
    private void checks() {
        System.out.println( date.getTime() );
        priceReturn = ventaService.consultar( date.getTime(), productId, 1 );
        Assert.notNull( priceReturn, "null Price object found: id=" + productId + ", date=" + date.toString() );
        Assert.notNull( priceReturn.getPrice(), "null price attribute found: id=" + productId + ", date=" + date.toString() );
    }

}
