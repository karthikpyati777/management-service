package in.karthik.mapper;

import in.karthik.dto.EmployeeDto;
import in.karthik.entity.Employee;

public class EmployeeMapper {
	 public static EmployeeDto mapToEmployeeDto(Employee employee){
	        EmployeeDto employeeDto = new EmployeeDto(
	                employee.getId(),
	                employee.getFirstName(),
	                employee.getLastName(),
	                employee.getEmail(),
	                employee.getDepartmentCode(),
	                employee.getOrganizationCode()
	        );
	        return employeeDto;
	    }

	    public static Employee mapToEmployee(EmployeeDto employeeDto){
	        Employee employee = new Employee(
	                employeeDto.getId(),
	                employeeDto.getFirstName(),
	                employeeDto.getLastName(),
	                employeeDto.getEmail(),
	                employeeDto.getDepartmentCode(),
	                employeeDto.getOrganizationCode()
	        );
	        return employee;
	    }
}
