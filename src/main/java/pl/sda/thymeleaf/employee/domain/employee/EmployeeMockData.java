package pl.sda.thymeleaf.employee.domain.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
class EmployeeMockData {

    private final EmployeeService service;

    @PostConstruct
    void saveMockEmployees() {
        List<Employee> employees = List.of(
                createEmployee("Andrzej", "Golota", "golota@o2.pl", "123456789", 55),
                createEmployee("Lech", "Zimny", "zimny@o2.pl", "4712345678", 70),
                createEmployee("Szymon", "Hamownia", "sz.h@o2.pl", "123123123", 55),
                createEmployee("Robert", "Hunter", "hunter@wp.pl", "5555555555", 32),
                createEmployee("Iksik", "Iksinski", "iksik@wp.pl", "123456789", 18),
                createEmployee("Mike", "Tyson", "golota@o2.pl", "456897123", 52),
                createEmployee("Evander", "Holyfield", "bokser@gmail.com", "456789123", 52),
                createEmployee("Andrzej", "Golota", "golota@o2.pl", "123456789", 55),
                createEmployee("Lech", "Zimny", "zimny@o2.pl", "4712345678", 70),
                createEmployee("Szymon", "Hamownia", "sz.h@o2.pl", "123123123", 55),
                createEmployee("Robert", "Hunter", "hunter@wp.pl", "5555555555", 32),
                createEmployee("Iksik", "Iksinski", "iksik@wp.pl", "123456789", 18),
                createEmployee("Mike", "Tyson", "golota@o2.pl", "456897123", 52),
                createEmployee("Evander", "Holyfield", "bokser@gmail.com", "456789123", 52),
                createEmployee("Andrzej", "Golota", "golota@o2.pl", "123456789", 55),
                createEmployee("Lech", "Zimny", "zimny@o2.pl", "4712345678", 70),
                createEmployee("Szymon", "Hamownia", "sz.h@o2.pl", "123123123", 55),
                createEmployee("Robert", "Hunter", "hunter@wp.pl", "5555555555", 32),
                createEmployee("Iksik", "Iksinski", "iksik@wp.pl", "123456789", 18),
                createEmployee("Mike", "Tyson", "golota@o2.pl", "456897123", 52),
                createEmployee("Evander", "Holyfield", "bokser@gmail.com", "456789123", 52),
                createEmployee("Andrzej", "Golota", "golota@o2.pl", "123456789", 55),
                createEmployee("Lech", "Zimny", "zimny@o2.pl", "4712345678", 70),
                createEmployee("Szymon", "Hamownia", "sz.h@o2.pl", "123123123", 55),
                createEmployee("Robert", "Hunter", "hunter@wp.pl", "5555555555", 32),
                createEmployee("Iksik", "Iksinski", "iksik@wp.pl", "123456789", 18),
                createEmployee("Mike", "Tyson", "golota@o2.pl", "456897123", 52),
                createEmployee("Evander", "Holyfield", "bokser@gmail.com", "456789123", 52)
        );
        service.saveEmployees(employees);
    }

    private Employee createEmployee(String name, String surname, String email, String pesel, Integer age) {
        return new Employee()
                .setName(name)
                .setSurname(surname)
                .setEmail(email)
                .setPesel(pesel)
                .setAge(age);
    }
}
