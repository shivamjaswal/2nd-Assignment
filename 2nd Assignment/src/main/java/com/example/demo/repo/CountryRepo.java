package com.example.demo.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Country;

@Repository("countryRepository")
public interface CountryRepo extends CrudRepository<Country, Long> {

	@Query(value="select country.name from country where id= :id",nativeQuery = true)
	public String findCountrybyid(Long id);
	
}