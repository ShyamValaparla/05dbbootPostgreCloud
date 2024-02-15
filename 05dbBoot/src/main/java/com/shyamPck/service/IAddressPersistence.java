package com.shyamPck.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shyamPck.entities.address;

public interface IAddressPersistence extends JpaRepository<address, Long> {

}
