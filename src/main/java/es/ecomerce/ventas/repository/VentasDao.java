package es.ecomerce.ventas.repository;

import es.ecomerce.ventas.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VentasDao extends JpaRepository<Price, Integer > {

     @Query( "select p from Price p where p.startDate < :fecha and p.endDate > :fecha and p.productId = :id and p.brandId = :brandId" )
     public List<Price> consultar(@Param("fecha") Date fecha, @Param("id")Long id, @Param("brandId")Long brandId );

}
