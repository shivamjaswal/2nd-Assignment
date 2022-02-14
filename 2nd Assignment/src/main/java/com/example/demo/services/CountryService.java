package com.example.demo.services;

import com.example.demo.entity.Country;

public interface CountryService {

	public Iterable<Country> findAll();

	public Country findCountry(long id);

}