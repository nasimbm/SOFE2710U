// Abstract class demonstrating Abstraction
abstract class Employee {
    // Encapsulated fields
    private String name;
    private int id;
    protected double baseSalary;

    // Constructor
    public Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    // Abstract method (Abstraction)
    public abstract double calculateSalary();

    // Concrete method
    public void displayInfo() {
        System.out.println("Employee ID: " + id + ", Name: " + name);
    }

    // Getter methods (Encapsulation)
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Setter method with validation (Encapsulation)
    public void setBaseSalary(double baseSalary) {
        if (baseSalary > 0) {
            this.baseSalary = baseSalary;
        } else {
            System.out.println("Invalid salary amount");
        }
    }
}

// Manager class demonstrating Inheritance
class Manager extends Employee {
    private double bonus;

    public Manager(String name, int id, double baseSalary, double bonus) {
        super(name, id, baseSalary);
        this.bonus = bonus;
    }

    // Implementing abstract method (Abstraction + Inheritance)
    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }

    // Method Overloading (Polymorphism)
    public void assignProject(String project) {
        System.out.println("Manager " + getName() + " assigned to project: " + project);
    }

    public void assignProject(String project, String team) {
        System.out.println("Manager " + getName() + " assigned to project: " + project + " with team: " + team);
    }
}

// Developer class demonstrating Inheritance and Polymorphism
class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, int id, double baseSalary, String programmingLanguage) {
        super(name, id, baseSalary);
        this.programmingLanguage = programmingLanguage;
    }

    // Implementing abstract method (Abstraction + Inheritance)
    @Override
    public double calculateSalary() {
        return baseSalary + (baseSalary * 0.1); // 10% bonus for developers
    }

    // Method demonstrating protected field access
    public void displaySkill() {
        System.out.println(getName() + " is skilled in " + programmingLanguage + " programming");
    }
}

// Main class to demonstrate all concepts
public class OOPDemo1 {
    public static void main(String[] args) {
        // Polymorphism: treating Manager and Developer as Employee
        Employee manager = new Manager("Alice", 1, 80000, 10000);
        Employee developer = new Developer("Bob", 2, 70000, "Java");

        // Demonstrating Polymorphism
        System.out.println("Manager's salary: $" + manager.calculateSalary());
        System.out.println("Developer's salary: $" + developer.calculateSalary());

        // Demonstrating Encapsulation
        manager.displayInfo();
        developer.displayInfo();

        manager.setBaseSalary(85000); // Salary updated
        manager.setBaseSalary(-1000); // Invalid salary, not updated

        // Demonstrating Inheritance
        ((Manager) manager).assignProject("Project A");
        ((Manager) manager).assignProject("Project B", "Team X");

        // Demonstrating protected field access
        ((Developer) developer).displaySkill();

        // Demonstrating Abstraction
        // Employee employee = new Employee("John", 3, 60000); // This would cause an error

        // Array of employees demonstrating Polymorphism
        Employee[] employees = {manager, developer};
        for (Employee emp : employees) {
            emp.displayInfo();
            System.out.println("Salary: $" + emp.calculateSalary());
            System.out.println();
        }
    }
}
