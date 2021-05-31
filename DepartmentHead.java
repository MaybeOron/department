public class DepartmentHead extends Lecturer {
    private String areaOfExpertise;
    private String degree;

    public DepartmentHead(String firstName, String lastName, int yearsOfExperience,
                          String areaOfExpertise, String degree) {
        super(firstName, lastName, yearsOfExperience);
        this.areaOfExpertise = areaOfExpertise;
        this.degree = degree;
    }

    public void print() {
        super.print();
        System.out.println("Expertise: " + this.areaOfExpertise);
        System.out.println("Degree: " + this.degree);
        System.out.println();
    }

    public String getAreaOfExpertise() {
        return this.areaOfExpertise;
    }

    public void setAreaOfExpertise(String areaOfExpertise) {
        this.areaOfExpertise = areaOfExpertise;
    }

    public String getDegree() {
        return this.degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
