package pl.sda.thymeleaf.employee.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping
    String redirect() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    String getEmployees(final Model model) {
        List<Employee> employees = service.getAll();
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/add-employee-form")
    String addEmployeeForm(final Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add-employee";
    }

    @PostMapping("/add-employee")
    String addEmployee(Employee employee) {
        service.saveEmployees(List.of(employee));
        return "redirect:/index";
    }

}
