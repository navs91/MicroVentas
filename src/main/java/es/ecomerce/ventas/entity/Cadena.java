package es.ecomerce.ventas.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class Cadena {

    @Id
    @Column( name = "BRAND_ID")
    long brandId;
    @Column( name = "NAME")
    String name;

    public Cadena() {

    }

    public Cadena(long brandId, String name) {
        this.brandId = brandId;
        this.name = name;
    }
}
