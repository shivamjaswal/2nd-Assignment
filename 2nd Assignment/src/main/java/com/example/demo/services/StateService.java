package com.example.demo.services;
import java.util.List;

import com.example.demo.entity.State;

public interface StateService {

	public List<State> findByCountry(int id);

}