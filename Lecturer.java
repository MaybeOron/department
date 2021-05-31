public class Lecturer extends Person {
    private int yearsOfExperience;

    public Lecturer(String firstName, String lastName, int yearsOfExperience) {
        super(firstName, lastName);
        this.yearsOfExperience = yearsOfExperience;
    }

    public void print() {
        super.print();
        System.out.println("Experience: " + this.yearsOfExperience + " years");
    }

    public int getYearsOfExperience() {
        return this.yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
