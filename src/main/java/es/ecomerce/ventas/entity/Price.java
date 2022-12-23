package es.ecomerce.ventas.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Comparator;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "Precios" )
public class Price implements Comparator {

    @Column( name = "BRAND_ID" )
    private long brandId;

    @Column( name = "START_DATE" )
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column( name = "END_DATE" )
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Id
    @Column( name = "PRICE_LIST" )
    private int priceList;
    @Column( name = "PRODUCT_ID" )
    private long productId;

    @Column( name = "PRIORITY" )
    private int priority;

    @Column( name = "PRICE" )
    private float price;

    @Column( name = "CURR" )
    private String currency;

    @Override
    public String toString() {
        return "Price{" +
                "brandId=" + brandId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", productId=" + productId +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                '}';
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
