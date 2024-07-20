package in.karthikit.organizationservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.karthikit.organizationservice.dto.OrganizationDto;
import in.karthikit.organizationservice.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

	public Organization findByOrganizationCode(String orgCode);
}
