package com.spicable.spicable.Controllers;
//controller file
import com.spicable.spicable.Controllers.dto.SpiceDto;
import com.spicable.spicable.Entity.Spices;
import com.spicable.spicable.Repositories.SpicesRepository;
import com.spicable.spicable.service.SpiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/spices")
public class SpicesController {


     final SpiceService spiceService;

    public SpicesController(@Autowired SpiceService spiceService) {
        this.spiceService = spiceService;
    }

    @GetMapping
    public Iterable<Spices> getSpices() {
        return spiceService.all();
    }

//    @PostMapping
//    public Spices addSpices(@RequestBody Spices spice) {
//        return spiceService.save(spice);
//    }


//    @PutMapping( "/{id}" )
//    public Spices update(@RequestBody Spices spice, @PathVariable Integer id )
//    {
//        Spices spices = spiceService.findById( id );
//        spices.setName( spices.getName() );
//        spices.setDescription( spices.getDescription() );
//        return spiceService.save( spices );
//    }

    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        spiceService.delete( id );
    }

    @PostMapping
    public Spices save( @RequestBody SpiceDto spiceDto )
    {
        return spiceService.save( new Spices(spiceDto) );
    }
    @GetMapping("/{id}")
    public Spices findItemById( @PathVariable Integer id ){
        return spiceService.findById( id );
    }
    @PutMapping( "/{id}" )
    public Spices update( @RequestBody SpiceDto spiceDto, @PathVariable Integer id )
    {
        Spices spice = spiceService.findById( id );
        spice.setName( spiceDto.getName() );
        spice.setDescription( spiceDto.getDescription() );
        spice.setQuantity( spiceDto.getQuantity() );
        spice.setPrice( spiceDto.getPrice() );
        return spiceService.save( spice );
    }



}
