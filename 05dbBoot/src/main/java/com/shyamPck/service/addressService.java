package com.shyamPck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shyamPck.entities.address;

@Component
public class addressService {
	@Autowired
	IAddressPersistence addressI;

	public List<address> getAddresses() {
		return addressI.findAll();
	}

	public address createAddress(address payloadReceived) {

		return addressI.save(payloadReceived);
	}

}
