package org.transportreservation.repository;

import org.springframework.stereotype.Repository;
import org.transportreservation.connection.ConnectionDB;
import org.transportreservation.model.Customer;
import org.transportreservation.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAO implements EmployeeInterfaceDAO {

    private Connection connection;

    //dependency injection
    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Employee employee) {
        String sql = "INSERT INTO employee(" +
                "employee_firstname, " +
                "employee_lastname, " +
                "employee_address, " +
                "employee_national_id, " +
                "employee_mobile_number, " +
                "employee_role, " +
                "employee_password) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employee.getEmployee_firstname());
            statement.setString(2, employee.getEmployee_lastname());
            statement.setString(3, employee.getEmployee_address());
            statement.setLong(4, employee.getEmployee_national_id());
            statement.setString(5, employee.getEmployee_mobile_number());
            statement.setString(6, employee.getEmployee_role());
            statement.setString(7, employee.getEmployee_password());

            statement.executeUpdate();
            System.out.println("Entity inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> allEmployees = new ArrayList<>();
        String sql = "SELECT * FROM employee";

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                allEmployees.add(new Employee(
                        result.getInt("id_employee"),
                        result.getString("employee_firstname"),
                        result.getString("employee_lastname"),
                        result.getString("employee_address"),
                        result.getLong("employee_national_id"),
                        result.getString("employee_mobile_number"),
                        result.getString("employee_role"),
                        result.getString("employee_password")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEmployees;
    }

    @Override
    public List<Employee> getByName(String name) {
        List<Employee> allEmployees = new ArrayList<>();
        String sql = "SELECT * FROM employee WHERE employee_firstname LIKE '%" + name + "%'";

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                allEmployees.add(new Employee(
                        result.getInt("id_employee"),
                        result.getString("employee_firstname"),
                        result.getString("employee_lastname"),
                        result.getString("employee_address"),
                        result.getLong("employee_national_id"),
                        result.getString("employee_mobile_number"),
                        result.getString("employee_role"),
                        result.getString("employee_password")
                ));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return allEmployees;
    }

    @Override
    public Employee getById(int id) {
        String sql = "SELECT * FROM employee WHERE id_employee = " + id;

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                Employee employee = new Employee(
                        result.getInt("id_employee"),
                        result.getString("employee_firstname"),
                        result.getString("employee_lastname"),
                        result.getString("employee_address"),
                        result.getLong("employee_national_id"),
                        result.getString("employee_mobile_number"),
                        result.getString("employee_role"),
                        result.getString("employee_password")
                );
                return employee;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    @Override
// Use of Employee as a return value to get the updated table
    public Employee updateAddressById(int id, String address) {
        String sql = "UPDATE employee SET employee_address = ? WHERE id_employee = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, address);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
// Use of the method getById to get the updated table
        return getById(id);
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM employee WHERE id_employee = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
