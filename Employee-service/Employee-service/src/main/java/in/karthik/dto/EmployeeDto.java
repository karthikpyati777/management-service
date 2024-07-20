package in.karthik.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        description = "EmployeeDto Model Information"
)
public class EmployeeDto {

	private Long id;
	@Schema(
            description = "Employee First Name"
    )
	private String firstName;
	@Schema(
            description = "Employee Last Name"
    )
	private String lastName;
	@Schema(
            description = "Employee Gmail id "
    )
	private String email;
	
	@Schema(
            description = "Employee Department Code"
    )
	private String departmentCode;
	@Schema(
            description = " department Description"
    )
	private String organizationCode;
	
}
