package com.spicable.spicable.Controllers;
//controller file
import com.spicable.spicable.Entity.Spices;
import com.spicable.spicable.Repositories.SpicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/spices")
public class SpicesController {

    @Autowired
    private final SpicesRepository spicesRepository;

    public SpicesController(final SpicesRepository spicesRepository) {
        this.spicesRepository = spicesRepository;
    }

    @GetMapping
    public Iterable<Spices> getSpices() {
        return spicesRepository.findAll();
    }

    @PostMapping
    public Spices addSpices(@RequestBody Spices spice) {
        return spicesRepository.save(spice);
    }

    @PutMapping("/{id}")

    public Spices updateSpice(@PathVariable("id") Integer id, @RequestBody Spices p
    ) {
        Optional<Spices> spicesToUpdateOptional = this.spicesRepository.findById(id);
        if (!spicesToUpdateOptional.isPresent()) {
            return null;
        }
        Spices spicesToUpdate = spicesToUpdateOptional.get();
        if (p.getName() != null) {
            spicesToUpdate.setName(p.getName());
        }

        if (p.getDescription() != null) {
            spicesToUpdate.setDescription(p.getDescription());
        }

        if (p.getQuantity() != null) {
            spicesToUpdate.setQuantity(p.getQuantity());
        }

        if (p.getPrice() != null) {
            spicesToUpdate.setPrice(p.getPrice());
        }
        Spices updatedSpice = this.spicesRepository.save(spicesToUpdate);
        return spicesToUpdate;
    }

    @DeleteMapping("/{id}")

    public Spices deleteSpice(@PathVariable("id") Integer id) {
        Optional<Spices> spicesToDeleteOptional = this.spicesRepository.findById(id);
        if (!spicesToDeleteOptional.isPresent()) {
            return null;
        }

        Spices spicesToDelete = spicesToDeleteOptional.get();
        spicesRepository.delete(spicesToDelete);
        return spicesToDelete;
    }




}
