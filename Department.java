import java.util.Scanner;

public class Department {

    Scanner scanner = new Scanner(System.in);
    private int departmentNum;
    private String departmentName;
    private Course[] courses;
    private Lecturer[] lecturers;

    public Department(int headSubjectNum, String headSubjectName, Course[] courses, Lecturer[] lecturers) {
        this.departmentNum = headSubjectNum;
        this.departmentName = headSubjectName;
        this.courses = courses;
        this.lecturers = lecturers;
    }

    public Course[] getCourses() {
        return this.courses;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void print() {
        System.out.println("Department number: " + this.departmentNum);
        System.out.println("Department name: " + this.departmentName);
        System.out.println("Department lecturer(s): ");
        for (int i = 0; i < this.lecturers.length; i++) {
            if (lecturers[i] != null) {
                System.out.println((i + 1) + ".");
                this.lecturers[i].print();
            }
        }
        System.out.println();
        System.out.println("Department course(s): ");
        for (int i = 0; i < this.courses.length; i++) {
            if (courses[i] != null) {
                System.out.println((i + 1) + ".");
                this.courses[i].printCourseData();
            }
        }
    }

    public void addLecturer() {
        System.out.println("Enter the lecturer's first name: ");
        String lecturerFName = scanner.nextLine();
        System.out.println("Enter the lecturer's last name: ");
        String lecturerLName = scanner.nextLine();
        System.out.println("Enter the lecturer's years of experience: ");
        int lecturerYOE = scanner.nextInt();

        boolean isDone = false;
        for (int i = 0; i < lecturers.length; i++) {
            if (lecturers[i] == null) {
                lecturers[i] = new Lecturer(lecturerFName, lecturerLName, lecturerYOE);
                isDone = true;
                break;
            }
        }
        if (!isDone) {
            System.out.println("No room for lecturers.");
        } else {
            System.out.println("New lecturer added succesfully.");
        }
    }

    public void addCourse() {

        System.out.println("Choose a lecturer for the course: ");

        if (lecturers[0] != null && lecturers[1] == null) {
            // there is only one lecturer
            System.out.println("Enter a course name: ");
            System.out.print("-> ");
            String courseName = scanner.next();

            for (int j = 0; j < courses.length; j++) {
                if (courses[j] == null) {
                    courses[j] = new Course(courseName, this.lecturers[0]);
                    break;
                }
            }
            System.out.println("Course added successfully.");
        } else if ((lecturers[0] != null) && (lecturers[1] != null)) {
            // there are a few lecturers
            System.out.println("Enter a course name: ");
            System.out.print("-> ");
            String courseName2 = scanner.next();

            System.out.println("Choose a lecturer: ");
            for (int i = 0; i < lecturers.length; i++) {
                if (lecturers[i] != null) {
                    System.out.println((i + 1) + ". " +
                            lecturers[i].getFirstName() + " " + lecturers[i].getLastName());

                }
            }
            int lectNum = scanner.nextInt();
            for (int j = 0; j < courses.length; j++) {
                if (courses[j] == null) {
                    courses[j] = new Course(courseName2, lecturers[lectNum - 1]);
                    break;
                }
            }
            System.out.println("Course added successfully.");

        } else {
            // there are no lecturers
            System.out.println("Can not open course! no lecturers available.");
        }


    }

}
