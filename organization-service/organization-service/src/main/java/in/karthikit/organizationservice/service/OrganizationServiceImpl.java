package in.karthikit.organizationservice.service;

import org.springframework.stereotype.Service;

import in.karthikit.organizationservice.dto.OrganizationDto;
import in.karthikit.organizationservice.entity.Organization;
import in.karthikit.organizationservice.mapper.OrganizationMapper;
import in.karthikit.organizationservice.repository.OrganizationRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

	private OrganizationRepository repo;

	@Override
	public OrganizationDto saveorg(OrganizationDto organizationDto) {
		// TODO Auto-generated method stub
		Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
		;
		// Convert organizationDto into Organization JPA Entity
//		organization=OrganizationMapper.mapToOrganization(organizationDto);
		Organization organizationSave = repo.save(organization);
		OrganizationDto mapToOrganizationDto = OrganizationMapper.mapToOrganizationDto(organizationSave);

		return mapToOrganizationDto;
	}

	@Override
	public OrganizationDto getOrganizationById(String orgCode) {
		// TODO Auto-generated method stub
		Organization organization = repo.findByOrganizationCode(orgCode);
		return OrganizationMapper.mapToOrganizationDto(organization);
		
	}

	

}
