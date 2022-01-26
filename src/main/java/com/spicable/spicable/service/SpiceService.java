package com.spicable.spicable.service;

import com.spicable.spicable.Entity.Spices;

import java.util.List;

public interface SpiceService {
    Spices save(Spices spice);

    boolean delete(int spiceId);

    List<Spices> all();

    Spices findById (int spiceId);

    }
