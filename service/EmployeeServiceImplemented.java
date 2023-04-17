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

//    public  Employee findMinSalaryByDepartment(int department) {
//        Employee employeeMinSalary = null;
//        for (Employee employee: employees.values()) {
//
//        }
//        for (int i = 0; i < employees.size(); i++) {
//            if (department == employees.getDepartment()) {
//                if (employeeMinSalary == null || employeeMinSalary.getSalary() > employees[i].getSalary()) {
//                    employeeMinSalary = employees[i];
//                }
//            }
//        }
//        return employeeMinSalary;
//    }

//    private static Employee findMaxSalaryByDepartment(int department) {
//        Employee employeeMaxSalary = null;
//        for (int i = 0; i < employees.length; i++) {
//            if (department == employees[i].getDepartment()) {
//                if (employeeMaxSalary == null || employeeMaxSalary.getSalary() < employees[i].getSalary()) {
//                    employeeMaxSalary = employees[i];
//                }
//            }
//        }
//        return employeeMaxSalary;
//    }
//
//    private static long spentOnSalariesByMonthByDep(int department) {
//        long overallSalaries = 0;
//        for (int i = 0; i < employees.length; i++) {
//            if (department == employees[i].getDepartment()) {
//                overallSalaries += employees[i].getSalary();
//            }
//        }
//        return overallSalaries;
//    }
//
//    private static long findAverageSalaryByDepartment(int department) {
//        long overallSalaries = spentOnSalariesByMonthByDep(department);
//        int employeeCounter = 0;
//        for (int i = 0; i < employees.length; i++) {
//            if (department == employees[i].getDepartment()) {
//                employeeCounter++;
//            }
//        }
//        return overallSalaries/employeeCounter;
//    }
//
//    public static Employee[] indexSalaries(Employee[] employees, int index) {
//        for (Employee employee: employees) {
//            long indexedSalary = employee.getSalary() + index*employee.getSalary()/100;
//            employee.setSalary(indexedSalary);
//        }
//        return employees;
//    }
//
//    private static void printAllEmployeesByDepartment(int department) {
//        for (int i = 0; i < employees.length; i++) {
//            if (department == employees[i].getDepartment()) {
//                System.out.println("Employee №" + employees[i].getIdNumber());
//                System.out.println("Full name: " + employees[i].getFullName() + ", salary " + employees[i].getSalary() + " roubles");
//            }
//        }
//    }
}