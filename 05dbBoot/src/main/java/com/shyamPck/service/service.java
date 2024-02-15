package com.shyamPck.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shyamPck.entities.Vendor;

@Component
public class service {

	@Autowired
	IVendorPersistence vendor;

	public List<Vendor> readAllVendors() {

		return vendor.findAll();

	}

	public Vendor createVendor(Vendor postBodyreceived) {

		return vendor.save(postBodyreceived);

	}

	public List<Vendor> searchByCompanyName(String company) {
		return vendor.findByCompanyName(company);
	}

	public List<Vendor> searchByGSTNo(String gstNo) {
		return vendor.lookupVendorByGST(gstNo);
	}

	public Vendor updateVendor(Vendor payload) {
		Optional<Vendor> myVendor = vendor.findById(payload.getId());
		if (!myVendor.isPresent()) {
			return new Vendor((long) 0, "", "", "", "", "", "", null);
		}
		return vendor.save(payload);
	}

	public Optional<Vendor> readVendorById(Long code) {

		return vendor.findById(code);
	}

	public String deleteVendor(Long id) {
		vendor.deleteById(id);
		return "Deleted Record";
	}

}
