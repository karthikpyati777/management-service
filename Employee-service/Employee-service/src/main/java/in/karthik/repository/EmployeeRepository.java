package in.karthik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.karthik.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
