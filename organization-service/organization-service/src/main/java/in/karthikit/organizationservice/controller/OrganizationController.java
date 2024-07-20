package in.karthikit.organizationservice.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.karthikit.organizationservice.dto.OrganizationDto;
import in.karthikit.organizationservice.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/organizations")
@Tag(name = "CRUD REST APIs for Organization Resource", 
description = "CRUD REST APIs - Create Organization,  Get DepartmentByOrganizationCode")
public class OrganizationController {

	private OrganizationService service;
	
	@PostMapping
	  @Operation(summary = "Create Organization REST API", description = "Create Organization REST API is used to save Organization in a database")
		@ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
	public ResponseEntity<OrganizationDto> saveOrgnization(@RequestBody OrganizationDto organizationDto){
		
		OrganizationDto saveorg = service.saveorg(organizationDto);
		return new ResponseEntity<OrganizationDto>(saveorg, HttpStatus.CREATED);
		
	}
	
	
	 @Operation(summary = "Get OrganizationByCode REST API", description = "Get Organization By ID REST API is used to get a single Organization from the database")
		@ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
	@GetMapping("{orgCode}")
	public ResponseEntity<OrganizationDto> getOrgnizationById(@PathVariable String orgCode){
		
		OrganizationDto organizationById = service.getOrganizationById(orgCode);
		return new ResponseEntity<OrganizationDto>(organizationById,HttpStatus.OK);
		
	}
}
