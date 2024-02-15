package com.shyamPck.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shyamPck.entities.Vendor;
import com.shyamPck.service.service;

@Component
@RestController

public class VendorController {

	@Autowired
	service vendorService;

	@RequestMapping("/vendor")
	public List<Vendor> getVendors() {

		return vendorService.readAllVendors();
	}

	@RequestMapping("/vendor/{vendorCode}")
	public Vendor getVendorById(@PathVariable("vendorCode") Long code) {

		Optional<Vendor> searchResult = vendorService.readVendorById(code);
		if (!searchResult.isPresent()) {
			return new Vendor((long) 0, "", "", "", "", "", "", null);
		}
		return searchResult.get();
	}

	@PostMapping("/vendor")
	public Vendor createVendor(@RequestBody Vendor postBodyreceived) {
		return vendorService.createVendor(postBodyreceived);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/vendor")
	public Vendor updateVendor(@RequestBody Vendor vendor) {
		return vendorService.updateVendor(vendor);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/vendor/{id}")
	public String deleteVendor(@RequestBody Long id) {
		return vendorService.deleteVendor(id);
	}

	@RequestMapping("/vendor/lookup/{gstNo}")
	public List<Vendor> searchbyGSTNoVariable(@PathVariable String gstNo) {
		return vendorService.searchByGSTNo(gstNo);
	}

	@RequestMapping("/vendor/search")
	public List<Vendor> searchbycompanyname(@RequestParam String company123) {
		return vendorService.searchByCompanyName(company123);

	}

	@RequestMapping("/vendor/lookup")
	public List<Vendor> searchbyGSTNo(@RequestParam String gstNo) {
		return vendorService.searchByGSTNo(gstNo);
	}

}
