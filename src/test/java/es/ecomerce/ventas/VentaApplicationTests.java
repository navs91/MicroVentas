package es.ecomerce.ventas;

import es.ecomerce.ventas.controller.PriceController;
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
import java.util.Date;
import java.util.List;

@SpringBootTest
class VentaApplicationTests {

    @Autowired
    PriceController priceController;
    @Autowired
    VentaServiceImpl ventaService;

    Calendar date = Calendar.getInstance();
    long productId = 35455;
    Price priceReturn;

    @BeforeEach
    void cargaBD() {
        Calendar dateStart = Calendar.getInstance();
        Calendar dateEnd = Calendar.getInstance();
        Price price;

            // DATO 1
        dateStart.set( 2020, 5, 14, 0, 0,0 );
        dateEnd.set( 2020, 11, 31, 23,59,59 );
        price = Price.builder()
                .brandId( 1 )
                .startDate( convert( dateStart ) )
                .endDate( convert( dateEnd ) )
                .priceList( 2 )
                .productId(productId)
                .priority( 0 )
                .price( (float)35.5 )
                .currency( "EUR" )
                .build();
        ventaService.save( price );
        System.out.println( "DATO 1 : " + dateStart.getTime().toString() );

            // DATO 2
        dateStart.set( 2020, 5, 14, 15, 0,0 );
        dateEnd.set( 2020, 5, 14, 18,30,0 );
        price = Price.builder()
                .brandId( 1 )
                .startDate( convert( dateStart ) )
                .endDate( convert( dateEnd ) )
                .priceList( 1 )
                .productId(productId)
                .priority( 1 )
                .price( (float)25.45 )
                .currency( "EUR" )
                .build();
        ventaService.save( price );
        System.out.println( "DATO 2 : " + dateStart.getTime().toString() );

            // DATO 3
        dateStart.set( 2020, 5, 15,0,0,0 );
        dateEnd.set( 2020, 5, 15, 11,0,0 );
        price = Price.builder()
                .brandId( 1 )
                .startDate( convert( dateStart ) )
                .endDate( convert( dateEnd ) )
                .priceList( 3 )
                .productId(productId)
                .priority( 1 )
                .price( (float)30.5 )
                .currency( "EUR" )
                .build();
        ventaService.save( price );
        System.out.println( "DATO 3 : " + dateStart.getTime().toString() );

            // DATO 4
        dateStart.set( 2020,5,15,16,0,0 );
        dateEnd.set( 2020, 11, 31, 23,59,59 );
        price = Price.builder()
                .brandId( 1 )
                .startDate( convert( dateStart ) )
                .endDate( convert( dateEnd ) )
                .priceList( 4 )
                .productId(productId)
                .priority( 1 )
                .price( (float)38.95 )
                .currency( "EUR" )
                .build();
        ventaService.save( price );
        System.out.println( "DATO 4 : " + dateStart.getTime().toString() );
    }

    @Test
    void firstSave() {
        Calendar dateStart = Calendar.getInstance();
        Calendar dateEnd = Calendar.getInstance();
        Price price;
        Price priceReturn;
        String message;

        // DATO 1
        dateStart.set( 2020, 5, 14, 0,0,0 );
        dateEnd.set( 2020, 11, 31, 23,59,59 );
        price = Price.builder()
                .brandId( 1 )
                .startDate( convert( dateStart ) )
                .endDate( convert( dateEnd ) )
                .priceList( 2 )
                .productId( productId )
                .priority( 0 )
                .price( (float)35.5 )
                .currency( "EUR" )
                .build();
        priceReturn = ventaService.save( price );
        Assert.notNull( priceReturn, "priceReturn=" + priceReturn + ", price=" + price);

        Price priceConsult = ventaService.get( 2 );
        message = "with ID=" + productId + ", priceConsult=" + priceConsult + ", service=" + ventaService;
        Assert.notNull( priceConsult, "DB problem, impossible to recover Element " + message );
        Assert.isTrue( priceConsult.toString().equals( price.toString() ), "Price recovered differs from saved, " + message );
    }

    @Test
    void testOneService() {
        Price price;

        price = ventaService.get( 1 );
        Assert.notNull( price, "DB problem, impossible to recover Element with ID=" + productId
                + ", element=" + price + ", service=" + ventaService );
    }

    @Test
    void test_1() {
        priceReturn = null;
        date = Calendar.getInstance();
        date.set( 2020, 5, 14, 10, 0,0 );
    }

    @Test
    void test_2() {
        priceReturn = null;
        date = Calendar.getInstance();
        date.set( 2020, 5, 14, 16, 0,0 );
        checks();
    }

    @Test
    void test_3() {
        priceReturn = null;
        date = Calendar.getInstance();
        date.set( 2020, 5, 14, 21, 0,0 );
        checks();
    }

    @Test
    void test_4() {
        priceReturn = null;
        date = Calendar.getInstance();
        date.set( 2020, 5, 15, 10, 0,0 );
        checks();
    }

    @Test
    void test_5() {
        priceReturn = null;
        date = Calendar.getInstance();
        date.set( 2020, 5, 16, 21, 0,0 );
        checks();
    }
    //@AfterEach
    private void checks() {
        System.out.println( date.getTime() );
        priceReturn = ventaService.consultar( date.getTime(), productId, 1 );
        Assert.notNull( priceReturn, "null list: id=" + productId + ", date=" + date.toString() );
        Assert.notNull( priceReturn.getPrice(), "null list: id=" + productId + ", date=" + date.toString() );
    }

    private Timestamp convert( Calendar date ) {
        return new Timestamp( date.getTimeInMillis() );
    }

    private Date convert2( Calendar date ) {
        return new Timestamp( date.getTimeInMillis() );
    }

}
