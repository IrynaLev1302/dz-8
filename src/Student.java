public class Student {
    private static int idCounter = 0;
    private final int id;
    private final String firstName;
    private final String lastName;

    public Student(String firstName, String lastName) {
        this.id = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (ID: " + id + ")";
    }


}
