package org.example.collections;

import java.util.Objects;

public class Employee {
    private String fulName;
    private double salary;
    private int department;
    private final int id;
    private static int COUNTER = 1;

    public Employee(final String fulName, double salary, int department) {
        this.fulName = fulName;
        this.salary = salary;
        this.department = department;
        this.id = COUNTER++;
    }
    public int getId() {
        return id;
    }

    public String getFulName() {
        return fulName;
    }

    public void setFulName(String fulName) {
        this.fulName = fulName;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public int getDepartment(){
        return department;
    }
    public void setDepartment(int department){
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fulName='" + fulName + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        double salary = 0;
        return Double.compare(salary, employee.salary) == 0 && department == employee.department && id == employee.id && Objects.equals(fulName, employee.fulName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fulName, salary, department, id);
    }
}



