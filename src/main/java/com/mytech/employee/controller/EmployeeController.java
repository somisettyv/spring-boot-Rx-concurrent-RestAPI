package com.mytech.employee.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mytech.employee.dao.model.Employee;
import com.mytech.employee.service.EmplomentService;
import com.mytech.employee.service.model.EmployeeDto;

@Controller
public class EmployeeController {

	@Autowired
	EmplomentService emplomentService;

	//@GetMapping("/org/dept/{deptNo}/employee")
	@RequestMapping(value = "/org/dept/{deptNo}/employee", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Map> getAllEmployees(@PathVariable String deptNo) {

		Map<String, List<EmployeeDto>> responseMap = Collections.singletonMap("employees",
				emplomentService.getAllEmployees(Long.parseLong(deptNo)));

		return new ResponseEntity<Map>(responseMap, HttpStatus.OK);

	}
	
	
	
	//@PostMapping("org/dept/{deptNo}/employee")
	@RequestMapping(value="/org/dept/{deptNo}/employee", method=RequestMethod.POST, produces= {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<Void>   addEmployee(@RequestBody @NotNull Employee employee) {
		
		emplomentService.addEmployee(employee.getName(), employee.getJobName(), employee.getManagerName(),
				employee.getSalary());
		return ResponseEntity.noContent().build();
	}
	
	
	
	@RequestMapping(value = "", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> updateEmployee(@PathVariable Long deptNo, @PathVariable Long empNo,
			@RequestBody @NotNull Employee employee) {
		emplomentService.updateEmployee(deptNo, empNo, employee);

		return ResponseEntity.noContent().build();
	}

}
