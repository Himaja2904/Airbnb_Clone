package com.AirbnbClone.airbnb.Service;

import com.AirbnbClone.airbnb.Entity.Property;
import com.AirbnbClone.airbnb.Entity.User;
import com.AirbnbClone.airbnb.Repository.PropertyRepository;
import com.AirbnbClone.airbnb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private UserRepository userRepository;

    //create a property
    public Property createProperty(Property property, Long userId){
        User owner = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("user not found!"));
        property.setOwner(owner);
        return propertyRepository.save(property);
    }

    //getPropertyById
    public Property getPropertyById(Long propertyId){
        return propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("property not found"));
    }

    //getAllProperties
    public List<Property> getAllProperties(){
        return propertyRepository.findAll();
    }
}
