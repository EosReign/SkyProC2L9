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

    @GetMapping("")
    public String hello() {
        return "<span><b>Welcome to EmployeeMachine!</b><span><br>";
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
//Как использовать конструкцию мэппинга (value, params) чтобы он нормально отвечал как на /all?departmentId так и на /all?
    @GetMapping(path = "/all?departmentId")
    public String allDepartment(@RequestParam("departmentId") Integer department) throws DepartmentNotExistException {
        if (department <= 5 && department > 0) {
            return employeeService.getAllDepartmentEmployee(department);
        } else if (department != null) {
            return employeeService.getAllEmployeers();
        } else {
            throw new DepartmentNotExistException("Такого отдела не существует");
        }
    }
}
//p;
