package com.chibuokem.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.chibuokem.test.model.StaffInfo;

@Repository
public interface StaffRepo extends PagingAndSortingRepository<StaffInfo, Integer> {

}
