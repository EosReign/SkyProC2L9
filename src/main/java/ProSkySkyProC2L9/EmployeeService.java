package ProSkySkyProC2L9;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    List<Employee> arr = new ArrayList<>();

    public String getMaxDepartmentSalary(int department) {
        /*
        Employee maxSalary = new Employee("Nothing", department, 0);
        for (Employee employee : arr) {
            if (employee.getSalaryInfo() > maxSalary.getSalaryInfo()) {
                maxSalary = employee;
            }
        }
        return maxSalary.toString();
         */
        Optional<Employee> employee = arr.stream()
                .filter(man -> man.getDepartment() == (department))
                .max(Comparator.comparing(Employee::getSalaryInfo));
        return employee.toString();
    }

    public String getMinDepartmentSalary(int department) {
        /*
        Employee minSalary = new Employee("Nothing", department, MAX_VALUE);
        for (Employee employee : arr) {
            if (employee.getSalaryInfo() < minSalary.getSalaryInfo()) {
                minSalary = employee;
            }
        }
        return minSalary.toString();
         */
        Optional<Employee> employee = arr.stream()
                .filter(man -> man.getDepartment() == (department))
                .min(Comparator.comparing(Employee::getSalaryInfo));
        return employee.toString();
    }


    public String getAllDepartmentEmployee(int department) {
        /*
        String message = "Сотрудники отдела " + department + ": <br>";
        for (Employee employee : arr) {
            if (employee.getDepartment() == department) {
                message += employee.toString() + "; <br>";
            }
        }
        return message;
         */
        List<Employee> employee = arr.stream()
                .filter(man -> man.getDepartment() == (department))
                .collect(Collectors.toList());
        return employee.toString();
    }

    public String getAllEmployeers() {
        /*
        String message = "";
        for ( int i = 1; i < 6; i++) {
            message += "Сотрудники отдела " + i + ": <br>";
            for ( Employee employee : arr) {
                if (employee.getDepartment() == i) {
                    message += employee.toString();
                }
            }
        }
        return message;
        */

        List<Employee> employee = arr.stream()
                .sorted().collect(Collectors.toList());
        return employee.toString();
    }
}
// Ща попытаемся обновить со стримами
