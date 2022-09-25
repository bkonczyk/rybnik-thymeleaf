package pl.sda.thymeleaf.employee.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping
    String redirect() {
        return "redirect:/employees?page=1";
    }

    @GetMapping("/employees")
    String getEmployees(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size, Model model) {
        Page<Employee> employeePage = service.findPage(page, size);
        List<Employee> employees = employeePage.getContent();
        List<Integer> sizes = List.of(5, 10, 20);

        model.addAttribute("size", size);
        model.addAttribute("sizes", sizes);
        model.addAttribute("employees", employees);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", employeePage.getTotalPages());
        model.addAttribute("totalElements", employeePage.getTotalElements());

        return "index";
    }

    @GetMapping("/add-employee-form")
    String addEmployeeForm(final Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add-employee";
    }

    @PostMapping("/add-employee")
    String addEmployee(@Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "add-employee";
        }
        service.saveEmployees(List.of(employee));
        return "redirect:/index";
    }

    @GetMapping("/update-employee-form/{id}")
    String updateEmployeeForm(@PathVariable Long id, final Model model) {
        Employee employee = service.findById(id);
        model.addAttribute("employee", employee);
        return "update-employee";
    }

    @PostMapping("/update-employee")
    String updateEmployee(@Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "update-employee";
        }
        service.saveEmployees(List.of(employee));
        return "redirect:/index";
    }

    @GetMapping("/delete-employee/{id}")
    String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "redirect:/index";
    }
}