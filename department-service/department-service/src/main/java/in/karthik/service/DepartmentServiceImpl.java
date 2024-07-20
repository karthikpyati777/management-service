package in.karthik.service;

import org.springframework.stereotype.Service;

import in.karthik.dto.DepartmentDto;
import in.karthik.entity.Department;
import in.karthik.mapper.DepartmentMapper;
import in.karthik.repository.DepartmentRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

		// convert department dto to department jpa entity
		Department department = DepartmentMapper.mapToDepartment(departmentDto);

		Department savedDepartment = departmentRepository.save(department);

		DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);

		return savedDepartmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {

		Department department = departmentRepository.findByDepartmentCode(departmentCode);

		DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);

		return departmentDto;
	}

}
