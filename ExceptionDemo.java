// Custom exception for wrong age in Father
// Custom exception for wrong father's age
class WrongAge extends Exception {
    public WrongAge(String message) {
        super(message);
    }
}

// Custom exception for wrong son's age
class WrongSonAge extends Exception {
    public WrongSonAge(String message) {
        super(message);
    }
}

// Base class Father
class Father {
    int fatherAge;

    Father(int age) throws WrongAge {
        if (age < 0) {
            throw new WrongAge("Father's age cannot be negative!");
        }
        this.fatherAge = age;
        System.out.println("Father's age: " + fatherAge);
    }
}

// Derived class Son
class Son extends Father {
    int sonAge;

    Son(int fatherAge, int sonAge) throws WrongAge, WrongSonAge {
        super(fatherAge);   // Call Father constructor

        if (sonAge >= fatherAge) {
            throw new WrongSonAge("Son's age cannot be greater than or equal to Father's age!");
        }

        this.sonAge = sonAge;
        System.out.println("Son's age: " + sonAge);
    }
}

// Main driver class
public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            Son s1 = new Son(45, 20);   // Valid
            System.out.println("Object created successfully!\n");
        } 
        catch (WrongAge | WrongSonAge e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Testing error cases
        try {
            Son s2 = new Son(-50, 10);  // Invalid father age
        } 
        catch (WrongAge | WrongSonAge e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Son s3 = new Son(40, 45);   // Invalid son's age
        } 
        catch (WrongAge | WrongSonAge e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
