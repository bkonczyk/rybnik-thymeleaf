package pl.sda.thymeleaf.employee.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository repository;

    void saveEmployees(List<Employee> employees) {
        log.debug("Saving a list of employees");
        repository.saveAll(employees);
    }

    public List<Employee> getAll() {
        log.debug("Fetching all employees");
        return repository.findAll();
    }

    public Employee findById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
