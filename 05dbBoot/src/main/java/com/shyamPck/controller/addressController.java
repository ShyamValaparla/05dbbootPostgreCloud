package com.shyamPck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shyamPck.entities.address;
import com.shyamPck.service.addressService;

@RestController

public class addressController {

	@Autowired
	addressService addressService;

	@RequestMapping("/address")
	public List<address> getAddresses() {

		return addressService.getAddresses();
	}

	@PostMapping("/address")
	public address createAddress(@RequestBody address postBodyreceived) {
		return addressService.createAddress(postBodyreceived);
	}

}
