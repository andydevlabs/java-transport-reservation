package org.transportreservation.repository;

import org.transportreservation.connection.ConnectionDB;
import org.transportreservation.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDAO implements EmployeeInterfaceDAO{

    private Connection connection;

    //dependency injection
    public EmployeeDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public void insert(Employee employee) {
        String sql = "INSERT INTO employee(employee_firstname, employee_lastname, employee_address, employee_national_id, employee_mobile_number, employee_role, employee_password) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employee.getEmployee_firstname());
            statement.setString(2, employee.getEmployee_lastname());
            statement.setString(3, employee.getEmployee_address());
            statement.setDouble(4, employee.getEmployee_national_id());
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
        return null;
    }

    @Override
    public List<Employee> getByName(String name) {
        return null;
    }

    @Override
    public Employee getById(int id) {
        return null;
    }

    @Override
    public Employee updateUsernameById(int id, String username) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO(ConnectionDB.getConnection());
        Employee andy = new Employee(
                1,
                "Andy Avotiana",
                "RAZAFINDRAKOTO",
                "85 Itaosy Andranonahoatra",
                123456789,
                "+261340000000",
                "admin",
                "azerty");
        dao.insert(andy);
    }
}
