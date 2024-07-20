package in.karthik.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.karthik.dto.APIResponseDto;
import in.karthik.dto.DepartmentDto;
import in.karthik.dto.EmployeeDto;
import in.karthik.dto.OrganizationDto;
import in.karthik.entity.Employee;
import in.karthik.mapper.EmployeeMapper;
import in.karthik.repository.EmployeeRepository;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	private EmployeeRepository employeeRepository;

//	private RestTemplate restTemplate;
	private WebClient webClient;
//	private APIClient apiClient;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

		Employee saveDEmployee = employeeRepository.save(employee);

		EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(saveDEmployee);

		return savedEmployeeDto;
	}

//	 @CircuitBreaker(name = "${spring.application.name}", fallbackMethod =
//	 "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	@Override
	public APIResponseDto getEmployeeById(Long employeeId) {

        LOGGER.info("inside getEmployeeById() method");
		Employee employee = employeeRepository.findById(employeeId).get();

		//Using RestTemplate Approach
//		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
//				"http://localhost:8081/api/departments" + employee.getDepartmentCode(), DepartmentDto.class);
//
//		DepartmentDto departmentDto = responseEntity.getBody();

		//using WebClient Approach
		DepartmentDto departmentDto = webClient.get()
				.uri("http://localhost:8081/api/departments/" + employee.getDepartmentCode()).retrieve()
				.bodyToMono(DepartmentDto.class).block();

		
		//Using FeignClient approach
//		DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
//
		//using WebClient Approach
        OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:8083/api/organizations/" + employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();

		EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setEmployee(employeeDto);
		apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganization(organizationDto);
		return apiResponseDto;
	}

	public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception) {

        LOGGER.info("inside getDefaultDepartment() method");

		Employee employee = employeeRepository.findById(employeeId).get();

		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setDepartmentName("R&D Department");
		departmentDto.setDepartmentCode("RD001");
		departmentDto.setDepartmentDescription("Research and Development Department");

		EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setEmployee(employeeDto);
		apiResponseDto.setDepartment(departmentDto);
		return apiResponseDto;
	}
}