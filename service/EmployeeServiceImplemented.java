package pro.sky.hwstreams.service;
import org.springframework.stereotype.Service;
import pro.sky.hwstreams.Employee;
import pro.sky.hwstreams.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.hwstreams.Exceptions.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeServiceImplemented implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImplemented () {
        employees = new HashMap<>();
    }
    @Override
    public Employee addEmployee(String firstname, String lastName, int department, int salary) {
        Employee employee = new Employee(firstname, lastName, department, salary);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Such employee already exists");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }
    @Override
    public Employee removeEmployee(String firstname, String lastName) {
        Employee employee = findEmployee(firstname, lastName);
        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee.getFullName());
            return employee;
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public Employee findEmployee(String firstname, String lastName)  {
        String key = firstname + lastName;
        if (employees.containsKey(key)) {
            return employees.get(key);
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

}