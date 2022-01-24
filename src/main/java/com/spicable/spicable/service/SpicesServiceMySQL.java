package com.spicable.spicable.service;

import com.spicable.spicable.Entity.Spices;
import com.spicable.spicable.Repositories.SpicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class SpicesServiceMySQL {
    public class SpiceServiceMySQL implements SpiceService
    {
        private final SpicesRepository spicesRepository;

        public SpiceServiceMySQL(@Autowired SpicesRepository spicesRepository )
        {
            this.spicesRepository = spicesRepository;
        }

        @Override
        public Spices save(Spices spice)
        {
            return spicesRepository.save( spice );
        }

        @Override
        public void delete(int spiceId)
        {
            spicesRepository.deleteById( spiceId );
        }

        @Override
        public List<Spices> all()
        {
            List<Spices> result = new ArrayList<>();
            spicesRepository.findAll().forEach( result::add );
            return result;
        }
}
}


