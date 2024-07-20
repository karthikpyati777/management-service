package in.karthik.service;

import in.karthik.dto.APIResponseDto;
import in.karthik.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);

}
