package es.ecomerce.ventas.controller;

import es.ecomerce.ventas.entity.Price;
import es.ecomerce.ventas.service.VentaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping( "/home")
public class PriceController {

    @Autowired
    private VentaServiceImpl ventaService;

    @GetMapping( "/consultar" )
    public ResponseEntity<Price> consultar( @RequestBody Date fecha, @RequestBody long id, @RequestBody long brandId ) {
        return ResponseEntity.ok( ventaService.consultar(  fecha, id, brandId ) );
    }

    @PostMapping( )
    public ResponseEntity<Price> post( @RequestBody Price price ) {
        return ResponseEntity.ok( ventaService.save( price ) );
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Price> get( @PathVariable int id ) {

        return ResponseEntity.ok( ventaService.get( id ) );
    }

    @GetMapping()
    public List<Price> findAll() {
        return ventaService.findAll();
    }
}
