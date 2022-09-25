package pl.sda.thymeleaf.employee.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

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
        String username = request.getUsername();
        if (repository.existsById(username)) {
            throw new RuntimeException("Username " + username + " already exists");
        }
        return User.of(
                username,
                passwordEncoder.encode(request.getPassword()),
                "USER");
    }

    public User findByUsername(String username) {
        return repository
                .findById(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " was not found"));
    }
}
