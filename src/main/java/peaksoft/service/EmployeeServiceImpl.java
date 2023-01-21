package peaksoft.service;

import peaksoft.dao.EmployeeDao;
import peaksoft.dao.EmployeeDaoImpl;
import peaksoft.model.Employee;
import peaksoft.model.Job;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Author
 * Eliza Ashyrbaeva
 * Don't give up!
 **/
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDao ed = new EmployeeDaoImpl();

    @Override
    public String createEmployee() {
        ed.createEmployee();
        return "Successfully create !!!";

    }

    @Override
    public String addEmployee(Employee employee) {
        ed.addEmployee(employee);
        return "Successfully !!!";
    }

    @Override
    public String dropTable() {
        ed.dropTable();
        return "Successfully Drop !!!";
    }

    @Override
    public String cleanTable() {
        ed.cleanTable();
        return "Successfully clean !!!";

    }

    @Override
    public String  updateEmployee(Long id, Employee employee) {
        ed.updateEmployee(id,employee);
        return "Successfully !!!";
    }

    @Override
    public List<Employee> getAllEmployees() {
        return ed.getAllEmployees();
    }

    @Override
    public Employee findByEmail(String email) {
        return ed.findByEmail(email);
    }

    @Override
    public Map<Employee, Job> getEmployeeById(Long employeeId) {
        return ed.getEmployeeById(employeeId);
    }

    @Override
    public List<Employee> getEmployeeByPosition(String position) {
        return ed.getEmployeeByPosition(position);
    }
}
