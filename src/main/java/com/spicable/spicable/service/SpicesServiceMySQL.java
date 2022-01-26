package com.spicable.spicable.service;

import com.spicable.spicable.Entity.Spices;
import com.spicable.spicable.Repositories.SpicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SpicesServiceMySQL implements SpiceService
    {
        private final SpicesRepository spicesRepository;

        public SpicesServiceMySQL(@Autowired SpicesRepository spicesRepository )
        {
            this.spicesRepository = spicesRepository;
        }

        @Override
        public Spices save(Spices spice)
        {
            return spicesRepository.save( spice );
        }

        @Override
        public boolean delete(int spiceId)
        {
            spicesRepository.deleteById( spiceId );
            return false;
        }

        @Override
        public List<Spices> all()
        {
            List<Spices> result = new ArrayList<>();
            spicesRepository.findAll().forEach( result::add );
            return result;
        }

        @Override
        public Spices findById(int id){
           Optional<Spices> optionalSpice = spicesRepository.findById(id);
           Spices spice = null;
           if (optionalSpice.isPresent()){
               spice = optionalSpice.get();

           }else{
               throw new RuntimeException("spice not for id ::" + id);
           }
           return spice;
        }
}



