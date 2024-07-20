package in.karthik.service;

import in.karthik.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto saveDepartment(DepartmentDto departmentDto);

	DepartmentDto getDepartmentByCode(String code);
}
