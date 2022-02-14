package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.City;

public interface CityService {

	public List<City> findByState(int id);

}