package com.rodzyn.homework08hibernate.repository;

import com.rodzyn.homework08hibernate.model.weather.WeaterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<WeaterDetails, Long> {
}
