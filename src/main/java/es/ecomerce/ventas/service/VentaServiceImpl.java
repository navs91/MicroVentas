package es.ecomerce.ventas.service;

import es.ecomerce.ventas.entity.Price;
import es.ecomerce.ventas.repository.VentasDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentasDao ventasRepo;

    @Override
    public Price consultar( Date fecha, long id, long brandId ) {
        return ventasRepo.consultar( fecha, id, brandId ).stream()
                .sorted( (p, c) -> p.getPriority() - c.getPriority() ).findFirst()
                .orElse( new Price() );
    }

    @Override
    @Transactional
    public Price save( Price price ) {
        return ventasRepo.save( price );
    }

    @Override
    public Price get( int id ) {
        return ventasRepo.findById( id ).orElse( new Price() );
    }

    @Override
    public List<Price> findAll() {
        return ventasRepo.findAll();
    }
}
