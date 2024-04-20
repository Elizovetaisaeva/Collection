package org.example.collection;

import java.util.HashMap;
import java.util.Map;

public class EmployeeBook {
    private final Map<String, org.example.collections.Employee> employees = new HashMap<>();

    public void add(String fullName, double salary, int department) {
        String key = getKey(fullName);
        org.example.collections.Employee employee = new org.example.collections.Employee(fullName, salary, department);
        employees.put(key, employee);
    }


    public void delete(String fullName) {
        String key = getKey(fullName);
        if (!employees.containsKey(key)) {
            throw new IllegalStateException("Сотрудник не найден");
        }
        employees.remove(key);

    }

    public void delete(int id) {
        org.example.collections.Employee employeeToRemove = null;
        for (org.example.collections.Employee employee : employees.values()) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employees.remove(getKey(employeeToRemove.getFulName()));
        } else {
            throw new IllegalStateException("Сотрудник не найден");
        }

    }

    public void update(String fullName, double salary, int department) {
        if (!employees.containsKey(getKey(fullName))) {
            throw new IllegalStateException("Сотрудник не найден");
        }
        org.example.collections.Employee employee = employees.get(getKey(fullName));
        employee.setSalary(salary);
        employee.setDepartment(department);
    }

    public void printGroupedByDepartment() {
        for (int i = 1; i < 5; i++) {
            System.out.println("Номер отдела: " + i);
            printAll(i);
        }
    }

    private void printAll(int i) {
        for (org.example.collections.Employee employee : employees.values()) {
            if (employee == null) {
                continue;
            }
            System.out.println(employee);
        }
    }

    public void prinAll(int department) {
        for (org.example.collections.Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                System.out.println(employee);
            }
        }
    }

    public double getSum() {
        double sum = 0;
        for (org.example.collections.Employee employee : employees.values()) {
            sum += employee.getSalary();
        }
        return sum;

    }

    public double getSum(int department) {
        double sum = 0;
        for (org.example.collections.Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public org.example.collections.Employee getEmployeeWithMinSalary() {
        org.example.collections.Employee minEmployee = null;
        for (org.example.collections.Employee employee : employees.values()) {
            if (minEmployee == null || minEmployee.getSalary() > employee.getSalary()) {
                minEmployee = employee;
            }
        }
        return minEmployee;
    }

    public org.example.collections.Employee getEmployeeWithMinSalary(int department) {
        org.example.collections.Employee minEmployee = null;
        for (org.example.collections.Employee employee : employees.values()) {
            if (employee.getDepartment() != department) {
                continue;
            }
            if (minEmployee == null || minEmployee.getSalary() > employee.getSalary()) {
                minEmployee = employee;
            }
        }
        return minEmployee;
    }

    public org.example.collections.Employee getEmployeeWithMaxSalary() {
        org.example.collections.Employee maxEmployee = null;
        for (org.example.collections.Employee employee : employees.values()) {
            if (maxEmployee == null || maxEmployee.getSalary() > employee.getSalary()) {
                maxEmployee = employee;
            }
        }
        return maxEmployee;
    }

    public org.example.collections.Employee getEmployeeWithMaxSalary(int department) {
        org.example.collections.Employee maxEmployee = null;
        for (org.example.collections.Employee employee : employees.values()) {
            if (employee.getDepartment() != department) {
                continue;
            }
            if (maxEmployee == null || maxEmployee.getSalary() > employee.getSalary()) {
                maxEmployee = employee;
            }
        }
        return maxEmployee;

    }

    public double getAverageSalary() {
        double sum = 0;
        int employeesNum = 0;
        for (org.example.collections.Employee employee : employees.values()) {
            employeesNum++;
            sum += employee.getSalary();
        }
        return sum / employeesNum;
    }

    public double getAverageSalary(int department) {
        double sum = 0;
        int employeesNum = 0;
        for (org.example.collections.Employee employee : employees.values()) {
            if (employee.getDepartment() != department) {
                continue;
            }
            employeesNum++;
            sum += employee.getSalary();
        }
        return sum / employeesNum;
    }

    public void printAllNames() {
        for (org.example.collections.Employee employee : employees.values()) {
            System.out.println(employee.getFulName());
        }
    }

    public void printAllNames(int department) {
        for (org.example.collections.Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                System.out.println(employee.getFulName());
            }
        }
    }

    public void increaseSalary(int percent) {
        for (org.example.collections.Employee employee : employees.values()) {
            employee.setSalary(employee.getSalary()
                    + employee.getSalary() / 100 * percent);
        }
    }

    public void increaseSalary(int percent, int department) {
        for (org.example.collections.Employee employee : employees.values()) {
            if (employee.getDepartment() != department) {
            }
            employee.setSalary(employee.getSalary()
                    + employee.getSalary() / 100 * percent);
        }
    }

    public void printAllWithSalaryLess(double bound) {
        for (org.example.collections.Employee employee : employees.values()) {
            if (employee.getSalary() <= bound) {
                System.out.println(employee);
            }
        }
    }

    public void printAllWithSalaryMore(double bound) {
        for (org.example.collections.Employee employee : employees.values()) {
            if (employee.getSalary() > bound) {
                System.out.println(employee);
            }
        }
    }

    private static String getKey(String fullName) {
        return fullName.toLowerCase();
    }
}

