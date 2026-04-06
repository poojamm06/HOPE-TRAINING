import java.util.*;

// ABSTRACT CLASS (Abstraction)
abstract class Course {
    protected int id;
    protected String name;

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    // Abstract method
    public abstract void showDetails();
}

// INHERITANCE
class RegularCourse extends Course {
    private int capacity;

    public RegularCourse(int id, String name, int capacity) {
        super(id, name);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public void showDetails() {
        System.out.println(id + " - " + name + " (Capacity: " + capacity + ")");
    }
}

// ENCAPSULATION
class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// REGISTRATION CLASS
class Registration {
    private Student student;
    private Course course;

    public Registration(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
}

// SERVICE CLASS (Business Logic)
class RegistrationSystem {
    private List<Course> courses = new ArrayList<>();
    private List<Registration> registrations = new ArrayList<>();

    public void addCourse(Course c) {
        courses.add(c);
    }

    public void showCourses() {
        for (Course c : courses) {
            c.showDetails(); // POLYMORPHISM
        }
    }

    public void registerStudent(String name, int courseId) {

        Course selected = null;

        for (Course c : courses) {
            if (c.getId() == courseId) {
                selected = c;
                break;
            }
        }

        if (selected == null) {
            System.out.println("Course not found!");
            return;
        }

        // Duplicate check
        for (Registration r : registrations) {
            if (r.getStudent().getName().equals(name)
                    && r.getCourse().getId() == courseId) {
                System.out.println("Already registered!");
                return;
            }
        }

        registrations.add(new Registration(new Student(name), selected));
        System.out.println("Registered successfully!");
    }

    public void showRegistrations() {
        for (Registration r : registrations) {
            System.out.println(
                r.getStudent().getName() + " → " + r.getCourse().getName()
            );
        }
    }
}

// MAIN CLASS (Menu)
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RegistrationSystem system = new RegistrationSystem();

        // Add courses
        system.addCourse(new RegularCourse(1, "Math", 2));
        system.addCourse(new RegularCourse(2, "Science", 2));
        system.addCourse(new RegularCourse(3, "Computer", 2));

        while (true) {
            System.out.println("\n--- Course Registration System ---");
            System.out.println("1. View Courses");
            System.out.println("2. Register Student");
            System.out.println("3. View Registrations");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    system.showCourses();
                    break;

                case 2:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter course ID: ");
                    int id = sc.nextInt();

                    system.registerStudent(name, id);
                    break;

                case 3:
                    system.showRegistrations();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}