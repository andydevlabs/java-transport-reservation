package org.transportreservation.repository;

import org.transportreservation.model.Employee;

import java.util.List;

public interface EmployeeInterfaceDAO {
    void insert(Employee employee);

    List<Employee> getAll();

    List<Employee> getByName(String name);

    Employee getById(int id);

    Employee updateAddressById(int id, String address);

    void deleteById(int id);
}
