package in.karthik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.karthik.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	Department findByDepartmentCode(String departmentCode);

}
