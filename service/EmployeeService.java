package pro.sky.hwstreams.service;

import pro.sky.hwstreams.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {

    Employee addEmployee(String firstname, String lastName, int department, int salary);

    Employee removeEmployee(String firstname, String lastName);

    Employee findEmployee(String firstname, String lastName);

    Collection<Employee> findAll();
}

