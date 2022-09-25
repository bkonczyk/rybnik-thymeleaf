package pl.sda.thymeleaf.employee.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "users")
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class User {

    @Id
    @Column(unique = true)
    private String username;

    private String password;

    private String role;
}
