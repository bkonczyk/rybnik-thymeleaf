package pl.sda.thymeleaf.employee.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public void add(CreateUserRequest request) {
        User user = mapToUser(request);
        repository.save(user);
    }

    private User mapToUser(CreateUserRequest request) {
        return User.of(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                "USER");
    }
}
