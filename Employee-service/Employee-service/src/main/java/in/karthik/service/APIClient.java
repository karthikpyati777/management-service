//package in.karthik.service;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import in.karthik.dto.DepartmentDto;
//
//@FeignClient(url = "http://localhost:8081", value = "DEPARTMENT-SERVICE")
//public interface APIClient {
//
//	// Build get department rest api
//	@GetMapping("api/departments/{department-code}")
//	DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);
//
//}
