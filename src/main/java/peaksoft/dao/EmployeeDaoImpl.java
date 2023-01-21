package peaksoft.dao;

import peaksoft.config.Util;
import peaksoft.model.Employee;
import peaksoft.model.Job;

import javax.swing.*;
import java.sql.*;
import java.util.*;

/**
 * Author
 * Eliza Ashyrbaeva
 * Don't give up!
 **/
public class EmployeeDaoImpl implements EmployeeDao {
    private Connection cn;

    public EmployeeDaoImpl() {
        this.cn = Util.getConnection();
    }

    @Override
    public void createEmployee() {
        String sql = """
                create table employees(
                id serial primary key ,
                first_name varchar not null,
                last_name varchar not null,
                age int ,
                email varchar ,
                job_id int references jobs(id)
                );
                """;
        try (Statement st = cn.createStatement()) {
            st.execute(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void addEmployee(Employee employee) {
        String sql = "insert into employees (first_name ,last_name,age,email,job_id) values (?,?,?,?,?)";
        try (PreparedStatement pr = cn.prepareStatement(sql)) {
            pr.setString(1, employee.getFirstName());
            pr.setString(2, employee.getLastName());
            pr.setInt(3, employee.getAge());
            pr.setString(4, employee.getEmail());
            pr.setLong(5, employee.getJobId());
            pr.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void dropTable() {
        String sql = " drop table employees cascade ";
        try (Statement st = cn.createStatement()) {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void cleanTable() {
        String sql = "truncate table employees";
        try (Statement st = cn.createStatement()) {
            st.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        String sql = "UPDATE employees SET first_name = ?,last_name = ?,age = ?,email = ?, job_id = ? WHERE id = ?";
        try(PreparedStatement preparedStatement = cn.prepareStatement(sql)){
            preparedStatement.setString(1,employee.getFirstName());
            preparedStatement.setString(2,employee.getLastName());
            preparedStatement.setInt(3,employee.getAge());
            preparedStatement.setString(4,employee.getEmail());
            preparedStatement.setInt(5,employee.getJobId());
            preparedStatement.setLong(6,id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> em = new LinkedList<>();
        String sql = "select * from employees";
        try (Statement pr = cn.createStatement()) {
            ResultSet rs = pr.executeQuery(sql);
            while (rs.next()) {
                em.add(new Employee(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getInt("job_id")));
            }
            return em;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Employee findByEmail(String email) {
        String sql = "select * from employees where email=?";
        try (PreparedStatement pr = cn.prepareStatement(sql)) {
            pr.setString(1, email);
            pr.executeQuery();
            ResultSet rs = pr.getResultSet();
            Employee em = new Employee();
            while (rs.next()) {
                em.setFirstName(rs.getString("first_name"));
                em.setLastName(rs.getString("last_name"));
                em.setAge(rs.getInt("age"));
                em.setEmail(rs.getString("email"));
                em.setJobId(rs.getInt("job_id"));
            }
            return em;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<Employee, Job> getEmployeeById(Long employeeId) {
        String sql = "SELECT * FROM employees JOIN jobs ON employees.id = jobs.id WHERE employees.id = ?;";
        try(PreparedStatement preparedStatement = cn.prepareStatement(sql)){
            preparedStatement.setLong(1,employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Map<Employee,Job> employeeJobMap = new HashMap<>();
            while (resultSet.next()) {
                Employee employee = new Employee();
                Job job = new Job();
                employee.setId(resultSet.getLong(1));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setAge(resultSet.getInt("age"));
                employee.setEmail(resultSet.getString("email"));
                employee.setJobId(resultSet.getInt("job_id"));

                job.setId(resultSet.getLong(6));
                job.setPosition(resultSet.getString("position"));
                job.setProfession(resultSet.getString("profession"));
                job.setDescription(resultSet.getString("description"));
                job.setExperience(resultSet.getInt("experience"));
                employeeJobMap.put(employee,job);
            }
            return employeeJobMap;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Employee> getEmployeeByPosition(String position) {
        String sql = "SELECT * FROM employees JOIN jobs j ON j.id = employees.id WHERE position = ?;";
        List<Employee> employees = new LinkedList<>();
        try(PreparedStatement preparedStatement = cn.prepareStatement(sql)){
            preparedStatement.setString(1,position);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setAge(resultSet.getInt("age"));
                employee.setEmail(resultSet.getString("email"));
                employee.setJobId(resultSet.getInt("job_id"));
                employees.add(employee);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return employees;
    }
    }