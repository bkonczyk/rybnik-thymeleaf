package pl.sda.thymeleaf.employee.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository repository;

    void saveEmployees(List<Employee> employees) {
        log.debug("Saving a list of employees");
        repository.saveAll(employees);
    }
}
