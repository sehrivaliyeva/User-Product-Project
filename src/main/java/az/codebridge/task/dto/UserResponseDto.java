package az.codebridge.task.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {
    private Long id;
    private String userName;
    private String name;
    private String surname;
    private Integer age;
    private Double balance;
    private String  isActive;
}
