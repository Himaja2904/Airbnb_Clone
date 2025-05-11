package com.AirbnbClone.airbnb.Service;

import com.AirbnbClone.airbnb.Entity.Booking;
import com.AirbnbClone.airbnb.Entity.Property;
import com.AirbnbClone.airbnb.Repository.BookingRepository;
import com.AirbnbClone.airbnb.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    public Booking createBooking(Long propertyId, LocalDate startDate, LocalDate endDate){
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("property not found"));

        Booking booking = new Booking();
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setProperty(property);
        return bookingRepository.save(booking);
    }

    //getAllBookings
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    //get all bookings by property id
    public List<Booking> getBookingByProperty(Long propertyId){
        return bookingRepository.findByPropertyId(propertyId);
    }

    //delete booking
    public void deleteBookingById(Long id){
        bookingRepository.deleteById(id);
    }
}
