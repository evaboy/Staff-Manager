package com.chibuokem.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chibuokem.test.model.StaffInfo;
import com.chibuokem.test.service.StaffService;


@RestController
@RequestMapping(value="/")
public class ApiController {
	@Autowired
	StaffService staffService;
	
	//API Controller to get all staff information
	@GetMapping(value="get-all-staff")
	public Page<StaffInfo> getAllStaff() {
		return staffService.getAllStaffInTenBatches();
	}
	
	//API Controller to add a new Staff. This returns true if data was successfully added to database or false if not added
	@PostMapping(value="add-staff")
	public ResponseEntity<Map<String, String>> addStaff(@RequestBody StaffInfo staffInfo) {
		Map<String, String> response = new HashMap<>();
		StaffInfo staff = staffService.addStaff(staffInfo);
		if(staff==null) {
			response.put("status", "Unsuccessful");
		}else {
			response.put("status", "Successful");
		}
		return new ResponseEntity<Map<String,String>>(response,HttpStatus.OK);
	}
	
	//Api controller to update staff. However, this API assumes you want to update all info of a particular staff 
	@PostMapping(value="edit/id/{id}")
	public ResponseEntity<Map<String, String>> editStaff(@PathVariable("id") String id, @RequestBody StaffInfo info) {
		Map<String, String> response = new HashMap<>();
		StaffInfo staffUpdate = staffService.UpdateStaff(id, info);
		if(staffUpdate==null) {
			response.put("status", "Unsuccessful");
		}else {
			response.put("status", "Successful");
		}
		return new ResponseEntity<Map<String,String>>(response,HttpStatus.OK);
	}
}
