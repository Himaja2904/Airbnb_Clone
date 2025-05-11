package com.AirbnbClone.airbnb.Repository;

import com.AirbnbClone.airbnb.Entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
}
