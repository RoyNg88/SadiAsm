package Asm1.Control;

import Asm1.Course.CourseList;
import Asm1.ManagesStudentEnrolment.StudentEnrollmentManager;
import Asm1.Student.StudentList;

import java.util.Scanner;

public class PrintControl {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final StudentEnrollmentManager ENROLMENT_MANAGER = new EnrollmentControl();
    private static final StudentList STUDENT_DAO = new StudentList();
    private static final CourseList COURSE_DAO = new CourseList();


    static int studentId;
    static int courseId;
    static String semester;

     public static void Printallcoursesfor1studentin1semester() {
         System.out.println("=========== Print all courses for 1 student in 1 semester ==========");
         System.out.print("\tEnter student id: ");
         studentId = Integer.parseInt(SCANNER.nextLine());
         System.out.print("\tEnter semester: ");
         semester = SCANNER.nextLine();
         ENROLMENT_MANAGER.printAllCoursesForSpecificStudentInSpecificSemester(studentId, semester);

     }
    public static void Printallstudentsof1coursein1semester() {
        System.out.println("=========== Print all students of 1 course in 1 semester ==========");
        System.out.print("\tEnter course id: ");
        courseId = Integer.parseInt(SCANNER.nextLine());
        System.out.print("\tEnter semester: ");
        semester = SCANNER.nextLine();
        ENROLMENT_MANAGER.printAllStudentsOfSpecificCourseInSpecificSemester(courseId, semester);
    }
    public static void Printallcoursesofferedin1semester() {
         System.out.println("=========== Print all courses offered in 1 semester ==========");
         System.out.print("\tEnter semester: ");
         semester = SCANNER.nextLine();
         ENROLMENT_MANAGER.printAllCoursesOfferedInSpecificSemester(semester);
     }

}
