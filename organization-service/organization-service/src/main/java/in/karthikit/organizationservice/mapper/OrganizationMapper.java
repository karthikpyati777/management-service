package in.karthikit.organizationservice.mapper;

import in.karthikit.organizationservice.dto.OrganizationDto;
import in.karthikit.organizationservice.entity.Organization;

public class OrganizationMapper {

	
	public static OrganizationDto mapToOrganizationDto(Organization organizationSave) {
		OrganizationDto organizationDto=new OrganizationDto(
				organizationSave.getId(),
				organizationSave.getOrganizationName(),
				organizationSave.getOrganizationDescription(),
				organizationSave.getOrganizationCode(),
				organizationSave.getCreatedDate());
		return organizationDto;
	}
	
	public static Organization mapToOrganization(OrganizationDto organizationDto) {
		Organization organization=new Organization(
				organizationDto.getId(),
				organizationDto.getOrganizationName(),
				organizationDto.getOrganizationDescription(),
				organizationDto.getOrganizationCode(),
				organizationDto.getCreatedDate());
		return organization;
	}
	
}
