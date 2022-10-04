package ProSkySkyProC2L9;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    public final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/department")
    public String hello() {
        return "<span><b>Welcome to Calculator!</b><span><br>";
    }
// Как тут встраивать RequestMapping правильно? а то я пытаюсь его встроить, но он игнорируется
    @GetMapping(path = "/department/max-salary")
    public String maxSalary(@RequestParam("departmentId") int department) throws Exception {
        if (department <= 5 && department > 0) {
            return employeeService.getMaxDepartmentSalary(department);
        } else {
            throw new Exception("Такого отдела не существует");
        }
    }

    @GetMapping(path = "/department/min-salary")
    public String minSalary(@RequestParam("departmentId") int department) throws Exception {
        if (department <= 5 && department > 0) {
            return employeeService.getMinDepartmentSalary(department);
        } else {
            throw new Exception("Такого отдела не существует");
        }
    }

    @GetMapping(value = "", params = "/department/all?departmentId=5")
    public String allDepartment(@RequestParam("departmentId") int department) throws Exception {
        if (department <= 5 && department > 0) {
            return employeeService.getAllDepartmentEmployee(department);
        } else {
            throw new Exception("Такого отдела не существует");
        }
    }

    @GetMapping("/department/all")
    public String allEmployeers() {
        return employeeService.getAllEmployeers();
    }
}
//p;
