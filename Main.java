import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        { // Just to minimize all the hardcode
            Student student0 = new Student("oron0", "cohen0", 0);
            Student student00 = new Student("oron00", "cohen00", 10);
            Student student1 = new Student("oron1", "cohen1", 1);
            Student student2 = new Student("oron2", "cohen2", 2);
            Student student3 = new Student("oron3", "cohen3", 3);
            Student student4 = new Student("oron4", "cohen4", 4);

            Lecturer lecturer0 = new Lecturer("dan0", "dan0", 0);
            Lecturer lecturer1 = new Lecturer("dan1", "dan1", 1);
            Lecturer lecturer2 = new Lecturer("dan2", "dan2", 2);
            Lecturer lecturer3 = new Lecturer("dan3", "dan3", 3);
            Lecturer lecturer4 = new Lecturer("dan4", "dan4", 4);

            Course course0 = new Course("course0", lecturer0);
            course0.addStudent(student0);
            course0.addStudent(student00);
            Course course00 = new Course("course00", lecturer0);
            course00.addStudent(student0);
            course00.addStudent(student00);
            Course course1 = new Course("course1", lecturer1);
            course1.addStudent(student1);
            Course course2 = new Course("course2", lecturer2);
            course2.addStudent(student2);
            Course course3 = new Course("course2", lecturer3);
            course3.addStudent(student3);
            Course course4 = new Course("course2", lecturer4);
            course4.addStudent(student4);

            DepartmentHead departmentHead = new DepartmentHead("John", "Doe", 54, "Space", "PHd");

            Department[] departments = new Department[5];

            Course[] dep0courses = new Course[5];
            dep0courses[0] = course0;
            dep0courses[1] = course00;
            Lecturer[] dep0lecturers = new Lecturer[5];
            dep0lecturers[0] = lecturer0;
            dep0lecturers[1] = lecturer1;

            departments[0] = new Department(0, "dep0", dep0courses, dep0lecturers);

            Course[] dep1courses = new Course[5];
            dep1courses[0] = course1;
            Lecturer[] dep1lecturers = new Lecturer[2];
            dep1lecturers[0] = lecturer1;

            departments[1] = new Department(1, "dep1", dep1courses, dep1lecturers);


            chooseDepartment(departments); /// -----> Start
        }
    }

    public static void chooseDepartment(Department[] departments) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a department for forward action:");
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] != null) {
                System.out.println(i + "." + departments[i].getDepartmentName());
            }
        }
        System.out.print("-> ");
        int userDepChoice = scanner.nextInt();
        System.out.println("~~ chosen department menu: ");
        departmentMenu(departments, userDepChoice);
    }

    public static void departmentMenu(Department[] deps, int chosenDep) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number to choose an action:");
        System.out.println("0. Print department data.");
        System.out.println("1. Change the department's name.");
        System.out.println("2. Add a lecturer to the department.");
        System.out.println("3. Add a course to the department.");
        System.out.println("4. Choose an existing course and choose action.");
        System.out.println("5. Back to choose a department.");
        System.out.print("-> ");
        int chosenDepMenu = scanner.nextInt();
        System.out.println();
        switch (chosenDepMenu) {
            case 0:
                System.out.println("Chosen department data:");
                deps[chosenDep].print();
                departmentMenu(deps, chosenDep);
                break;
            case 1:
                System.out.println("Enter a new department name:");
                System.out.print("-> ");
                String newDepName = scanner.next();
                deps[chosenDep].setDepartmentName(newDepName);
                System.out.println();
                chooseDepartment(deps);
                break;
            case 2:
                deps[chosenDep].addLecturer();
                departmentMenu(deps, chosenDep);
                break;
            case 3:
                deps[chosenDep].addCourse();
                departmentMenu(deps, chosenDep);
                break;
            case 4:
                System.out.println("Choose a course to to proceed: ");
                Course[] thisDepCourses = deps[chosenDep].getCourses();
                for (int j = 0; j < thisDepCourses.length; j++) {
                    if (thisDepCourses[j] != null) {
                        System.out.println((j + 1) + ". " + thisDepCourses[j].getCourseName());
                    }
                }
                System.out.print("-> ");
                int chosenCourse = scanner.nextInt();
                System.out.println("Choose an action for this course: ");
                System.out.println("1. Print course data.");
                System.out.println("2. Change course name.");
                System.out.println("3. Add a student to the course.");
                System.out.println("4. Back to previous menu");
                System.out.print("-> ");
                int chosenCourseOption = scanner.nextInt();
                switch (chosenCourseOption) {
                    case 1:
                        thisDepCourses[chosenCourse - 1].printCourseData();
                        departmentMenu(deps, chosenDep);

                        break;
                    case 2:
                        System.out.println("2. Choose a new name: ");
                        System.out.print("-> ");
                        String newCourseName = scanner.next();
                        thisDepCourses[chosenCourse - 1].setCourseName(newCourseName);
                        departmentMenu(deps, chosenDep);
                        break;
                    case 3:
                        System.out.println("Enter the student's first name: ");
                        System.out.print("-> ");
                        String newStudentFN = scanner.next();
                        System.out.println("Enter the student's last name: ");
                        System.out.print("-> ");
                        String newStudentLN = scanner.next();
                        System.out.println("Enter the student's ID: ");
                        int newStudentID = scanner.nextInt();
                        thisDepCourses[chosenCourse - 1].addStudent
                                (new Student(newStudentFN, newStudentLN, newStudentID));
                        departmentMenu(deps, chosenDep);
                        break;
                    case 4:
                        departmentMenu(deps, chosenDep);
                        break;
                }
                break;
            case 5:
                chooseDepartment(deps);
        }
        System.out.println();
    }
}
