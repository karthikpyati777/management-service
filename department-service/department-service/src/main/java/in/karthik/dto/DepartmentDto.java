package in.karthik.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DepartmentDto Model Information")
public class DepartmentDto {
	private Long id;
	@Schema(description = "Department name")
	private String departmentName;
	@Schema(description = "Department Description")
	private String departmentDescription;
	@Schema(description = "Department Code")
	private String departmentCode;
}
