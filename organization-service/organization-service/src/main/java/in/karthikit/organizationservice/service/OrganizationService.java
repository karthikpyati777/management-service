package in.karthikit.organizationservice.service;

import java.util.Optional;

import in.karthikit.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
	
	
	OrganizationDto saveorg(OrganizationDto organizationDto);
	
	OrganizationDto getOrganizationById(String orgCode);

}
