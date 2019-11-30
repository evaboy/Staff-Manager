package com.chibuokem.test.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.chibuokem.test.model.StaffInfo;
import com.chibuokem.test.repository.StaffRepo;

@Service
public class StaffService {
	
	@Autowired
	StaffRepo staffRepo;
	
	//Returns a list of all the staff information from database in 10 batches
	public Page<StaffInfo> getAllStaffInTenBatches(){
		Page<StaffInfo> pages = staffRepo.findAll(PageRequest.of(0, 10));
		return  pages;
	}
	
	public StaffInfo addStaff(StaffInfo staffInfo) {
		return staffRepo.save(staffInfo);
	}
	
	public Iterable<StaffInfo> getAllStaff(){
		return staffRepo.findAll();
	}
	
	public StaffInfo UpdateStaff(String id, StaffInfo info) {
		Iterable<StaffInfo> staffToUpdate = getAllStaff();
		for(StaffInfo staff : staffToUpdate) {
			if(staff.getStaffId()==id) {
				staff.setState(info.getAddress());
				staff.setState(info.getPhoneNumber());
				staff.setState(info.getFirstName());
				staff.setState(info.getLastName());
				staff.setState(info.getMiddleName());
				staff.setState(info.getState());
				return staffRepo.save(staff);
			}
		}
		return null;
	}
}
