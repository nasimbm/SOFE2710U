// Abstract class demonstrating Abstraction
abstract class Vehicle {
    // Encapsulated fields
    private String brand;
    protected int year;

    // Constructor
    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    // Abstract method (Abstraction)
    public abstract void start();

    // Concrete method
    public void stop() {
        System.out.println("Vehicle stopping...");
    }

    // Getter method (Encapsulation)
    public String getBrand() {
        return brand;
    }

    // Setter method (Encapsulation)
    public void setYear(int year) {
        if (year > 1886) { // First automobile was invented in 1886
            this.year = year;
        } else {
            System.out.println("Invalid year");
        }
    }
}

// Car class demonstrating Inheritance
class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, int year, int numberOfDoors) {
        super(brand, year);
        this.numberOfDoors = numberOfDoors;
    }

    // Implementing abstract method (Abstraction + Inheritance)
    @Override
    public void start() {
        System.out.println("Car starting... Vroom!");
    }

    // Method Overloading (Polymorphism)
    public void accelerate() {
        System.out.println("Car accelerating...");
    }

    public void accelerate(int speed) {
        System.out.println("Car accelerating to " + speed + " mph");
    }

    public void displayInfo() {
        System.out.println("This " + getBrand() + " car was made in " + year + " and has" + numberOfDoors + " doors.");
    }
}

// Motorcycle class demonstrating Inheritance and Polymorphism
class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String brand, int year, boolean hasSidecar) {
        super(brand, year);
        this.hasSidecar = hasSidecar;
    }

    // Implementing abstract method (Abstraction + Inheritance)
    @Override
    public void start() {
        System.out.println("Motorcycle starting... Vroom vroom!");
    }

    // Method demonstrating protected field access
    public void displayInfo() {
        if (hasSidecar)
            System.out.println("This " + getBrand() + " motorcycle was made in " + year + " and has sideCar.");
        else
        System.out.println("This " + getBrand() + " motorcycle was made in " + year + " and doesn't have sideCar.");
    }
}

// Main class to demonstrate all concepts
public class OOPDemo2 {
    public static void main(String[] args) {
        // Polymorphism: treating Car and Motorcycle as Vehicle
        Vehicle car = new Car("Toyota", 2022, 4);
        Vehicle motorcycle = new Motorcycle("Harley-Davidson", 2021, false);

        // Demonstrating Polymorphism
        car.start(); // Calls Car's start method
        motorcycle.start(); // Calls Motorcycle's start method

        // Demonstrating Encapsulation
        System.out.println("Car brand: " + car.getBrand());
        car.setYear(2023); // Year updated
        // car.setYear(1800); // Invalid year, not updated

        // Demonstrating Inheritance
        ((Car) car).accelerate();
        ((Car) car).accelerate(60);

        // Demonstrating protected field access
        ((Motorcycle) motorcycle).displayInfo();

        // Demonstrating Abstraction
        // Vehicle vehicle = new Vehicle("Generic", 2020); // This would cause an error

        // Array of vehicles demonstrating Polymorphism
        Vehicle[] vehicles = {car, motorcycle};
        for (Vehicle v : vehicles) {
            v.start(); // Each vehicle starts in its own way
            v.stop(); // All vehicles use the same stop method
        }
    }
}
