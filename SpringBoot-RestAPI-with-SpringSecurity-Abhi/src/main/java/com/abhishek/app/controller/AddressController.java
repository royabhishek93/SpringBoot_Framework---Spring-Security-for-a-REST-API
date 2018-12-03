package com.abhishek.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.app.service.AddressService;
import com.abhishek.app.model.Address;


@RestController
@RequestMapping("/address")
public class AddressController {
	
	private AddressService  addressService;

	@Autowired
	public AddressController(AddressService addressService) {
		
		this.addressService = addressService;
	}
	
	@RequestMapping("/list")
	public List<Address> addressList(){
		return addressService.addressList();
	}
	
	@RequestMapping("/list/{id}")
	public Address findOne(@PathVariable Long id) {
		return addressService.findOne(id);
	}
	
	@RequestMapping("/add")
	public Address addAddress(@RequestBody Address address) {
		return addressService.addAddress(address);
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteAddress(@PathVariable Long id) {
		
		return addressService.deleteAddress(id);
		
	}
	
	

}
