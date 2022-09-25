package pl.sda.thymeleaf.employee.domain.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateUserRequest {

    private String username;
    private String password;
}
