package com.AirbnbClone.airbnb.Controller;

import com.AirbnbClone.airbnb.Entity.Property;
import com.AirbnbClone.airbnb.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    //create a property
    @PostMapping
    public Property createProperty(@RequestBody Property property,
                                   @RequestParam Long userId){
        return propertyService.createProperty(property,userId);
    }

    //get property by id
    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@RequestParam Long id){
        Property property = propertyService.getPropertyById(id);
        return ResponseEntity.ok(property);
    }

    //get all properties
    @GetMapping
    public List<Property> getAllProprties(){
        return propertyService.getAllProperties();
    }
}
