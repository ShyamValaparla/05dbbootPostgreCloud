package com.shyamPck.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shyamPck.entities.Vendor;

public interface IVendorPersistence extends JpaRepository<Vendor, Long> {

	List<Vendor> findByCompanyName(String companyName);

	@Query(nativeQuery = true, value = "SELECT * FROM PUBLIC.SPIDERMAN WHERE LOWER(GST_NO) LIKE %?1%")
	List<Vendor> lookupVendorByGST(String GSTNo);

}
