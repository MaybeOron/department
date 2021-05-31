public class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() { return this.lastName; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void print() {
        System.out.println("Name: " + this.firstName + " " + this.lastName);
    }
}
