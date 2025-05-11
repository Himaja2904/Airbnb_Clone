package com.AirbnbClone.airbnb.Controller;

import com.AirbnbClone.airbnb.Entity.Booking;
import com.AirbnbClone.airbnb.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    //posting a new booking in and association with property id
    @PostMapping
    public Booking createBooking(@RequestParam Long propertyId,
                                 @RequestParam LocalDate startDate,
                                 @RequestParam LocalDate endDate){
        return bookingService.createBooking(propertyId, startDate, endDate);
    }

    //get booking by id
    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id){
        return bookingService.getBookingById(id);
    }

    // get all bookings
    @GetMapping
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    //get bookings by property id
    @GetMapping("/property/{propertyId}")
    public List<Booking> getBookingByProperty(@PathVariable Long propertyId){
        return bookingService.getBookingByProperty(propertyId);
    }

    //delete booking by id
    @DeleteMapping("/delete/booking/{id}")
    public ResponseEntity<Void> deleteBookingById(@RequestParam Long id){
        bookingService.deleteBookingById(id);
        return ResponseEntity.noContent().build();
    }
}
