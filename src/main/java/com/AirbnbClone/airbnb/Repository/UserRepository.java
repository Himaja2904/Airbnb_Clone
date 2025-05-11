package com.AirbnbClone.airbnb.Repository;

import com.AirbnbClone.airbnb.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
