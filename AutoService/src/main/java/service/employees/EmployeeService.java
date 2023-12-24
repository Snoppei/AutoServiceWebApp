package service.employees;

import java.time.LocalDate;
import java.util.List;

import entity.Employee;

public interface EmployeeService {
    void createEmployee(String lastName, String firstName, String middleName, LocalDate dateOfBirth, String address, String contactPhone, String jobPosition, int salary, int experience, String workSchedule, int experienceBonus);
    void deleteEmployee(Long employeeId);
    List<Employee> getAllEmployees();
    boolean employeeExists(Long employeeId);
}
