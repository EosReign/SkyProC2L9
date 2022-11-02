package ProSkySkyProC2L9;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/department")
public class EmployeeController {
    public final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping(path = "/max-salary")
    public String maxSalary(@RequestParam("departmentId") int department) throws DepartmentNotExistException {
        if (department <= 5 && department > 0) {
            return employeeService.getMaxDepartmentSalary(department);
        } else {
            throw new DepartmentNotExistException("Такого отдела не существует");
        }
    }

    @GetMapping(path = "/min-salary")
    public String minSalary(@RequestParam("departmentId") int department) throws DepartmentNotExistException {
        if (department <= 5 && department > 0) {
            return employeeService.getMinDepartmentSalary(department);
        } else {
            throw new DepartmentNotExistException("Такого отдела не существует");
        }
    }
    @GetMapping(path = "/all")
    public String allDepartment(@RequestParam("departmentId") Integer department) throws DepartmentNotExistException {
        if (department == null) {
            return employeeService.getAllEmployeers();
        } else if (department <= 5 && department > 0) {
            return employeeService.getAllDepartmentEmployee(department);
        } else {
            throw new DepartmentNotExistException("Такого отдела не существует");
        }

    }
}
///*
