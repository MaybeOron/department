import java.util.Random;

public class Course {

    private String courseName;
    private Lecturer courseLecturer;
    private Student[] students;
    private int pointsValue;

    public Course(String courseName, Lecturer courseTeacher) {
        this.courseName = courseName;
        this.courseLecturer = courseTeacher;
        this.students = new Student[5]; // ** hardcoded number **
        Random rn = new Random();
        this.pointsValue = rn.nextInt(10) + 1;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int NumOfStudents() {
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                count++;
            }
        }
        return count;
    }

    public void printCourseData() {
        System.out.println("Course name: " + this.courseName);
        System.out.println("Course points : " + this.pointsValue);
        System.out.println("Lecturer info: ");
        this.courseLecturer.print();
        System.out.println("--");
        System.out.println("The course has " + NumOfStudents() + " student(s).");
        System.out.println("Course student list: ");
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                System.out.print((i + 1) + ". ");
                this.students[i].print(false);
            }
        }
        System.out.println("______ ");
        System.out.println();
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void addStudent(Student student) {
        boolean isDone = false;
        for (int i = 0; i <= this.students.length; i++) {
            if (this.students[i] == null) {
                this.students[i] = student;
                isDone = true;
           //     System.out.println("New student added successfully.");
                break;
            }
        }
        if (!isDone) {
            System.out.println("This class is full!");
        }
    }
}
