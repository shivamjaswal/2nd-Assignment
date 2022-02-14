package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Customer;
import com.example.demo.repo.CityRepo;
import com.example.demo.repo.CountryRepo;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.repo.StateRepo;


@Repository
public class CustomerDAO {

	@Autowired
	private CustomerRepo crudRepo;
	
	@Autowired
	 private CountryRepo countryRepository; 
	
	@Autowired
	private StateRepo stateRepository;
	
	@Autowired
	private CityRepo cityRepository;

	@Transactional
	public void saveData(Customer customerEntity) {
		String country = countryRepository.findCountrybyid(Long.valueOf(customerEntity.getCountry()));
		customerEntity.setCountry(country);
		String state = stateRepository.findStatebyid(Long.valueOf(customerEntity.getState()));
		customerEntity.setState(state);
		String city = cityRepository.findCitybyid(Long.valueOf(customerEntity.getCity()));
		customerEntity.setCity(city);
		crudRepo.save(customerEntity);
	}

	@Transactional
	public void updateData(Customer customerEntity) {
		String country = countryRepository.findCountrybyid(Long.valueOf(customerEntity.getCountry()));
		customerEntity.setCountry(country);
		String state = stateRepository.findStatebyid(Long.valueOf(customerEntity.getState()));
		customerEntity.setState(state);
		String city = cityRepository.findCitybyid(Long.valueOf(customerEntity.getCity()));
		customerEntity.setCity(city);
		crudRepo.updateByPhone(customerEntity.getName(),customerEntity.getCustomer_type(), customerEntity.getCountry(), customerEntity.getState(), customerEntity.getCity(), customerEntity.getStreet(), customerEntity.getPincode(),customerEntity.getUpdated_by(),customerEntity.getUpdated_on(),customerEntity.getPhone());
	}
	
	@Transactional
	public void deleteData(Customer customerEntity) {
		crudRepo.deletebyphone(customerEntity.getPhone());

	}
		
	@Transactional
	public List<Customer> searchData(Customer customerEntity) {
		List<Customer> alldata = (List<Customer>) crudRepo.findAll();
		return alldata;
	}
	
	@Transactional
	public List<Customer> searchDataByName(Customer employee) {
		List<Customer> findById = (List<Customer>)crudRepo.findByName(employee.getName());
		return findById;
	}


}
