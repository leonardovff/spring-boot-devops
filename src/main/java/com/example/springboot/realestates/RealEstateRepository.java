package com.example.springboot.realestates;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface RealEstateRepository extends CrudRepository<RealEstate, Integer> {
    RealEstate findBySku(@Param(value = "sku") Integer sku);
    
}