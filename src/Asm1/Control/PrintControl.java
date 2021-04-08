package Asm1.Control;

import Asm1.Main;
import Asm1.ManagesStudentEnrolment.StudentEnrollmentManager;
import Asm1.Utils.Menu;

import java.util.Scanner;

public class PrintControl {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final StudentEnrollmentManager ENROLMENT_MANAGER = new EnrollmentControl();

    static int studentId;
    static int courseId;
    static String semester;

    public static void PrintMenu(){
        Menu menu = new Menu("Control for Print");
        menu.addOption("Print enrollments for a student", PrintControl::Printallcoursesfor1studentin1semester);
        menu.addOption("Print enrollments for a course", PrintControl::Printallstudentsof1coursein1semester);
        menu.addOption("Print enrollments for a semester", PrintControl::Printallcoursesofferedin1semester);
        menu.addOption("Back main menu", Main::mainMenu);
        menu.start();
    }

     private static void Printallcoursesfor1studentin1semester() {
         System.out.print("\tEnter student id: ");
         studentId = Integer.parseInt(SCANNER.nextLine());
         System.out.print("\tEnter semester: ");
         semester = SCANNER.nextLine();
         ENROLMENT_MANAGER.printAllCoursesForSpecificStudentInSpecificSemester(studentId, semester);
         addBack();
     }
    private static void Printallstudentsof1coursein1semester() {
        System.out.print("\tEnter course id: ");
        courseId = Integer.parseInt(SCANNER.nextLine());
        System.out.print("\tEnter semester: ");
        semester = SCANNER.nextLine();
        ENROLMENT_MANAGER.printAllStudentsOfSpecificCourseInSpecificSemester(courseId, semester);
        addBack();
    }
    private static void Printallcoursesofferedin1semester() {
         System.out.print("\tEnter semester: ");
         semester = SCANNER.nextLine();
         ENROLMENT_MANAGER.printAllCoursesOfferedInSpecificSemester(semester);
         addBack();
     }
    private static void addBack() {
        Menu menu = new Menu("");
        menu.addOption("Back", Main::mainMenu);
        menu.start();
    }
}
