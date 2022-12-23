package es.ecomerce.ventas.service;

import es.ecomerce.ventas.entity.Price;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public interface VentaService {

    public Price consultar( Date fecha, long id, long cad );
    public Price save( Price precio );
    public Price get( int id );

    public List<Price> findAll();

}
