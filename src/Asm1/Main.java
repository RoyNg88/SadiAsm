package Asm1;

import Asm1.Control.EnrollmentControl;
import Asm1.Control.PrintControl;
import Asm1.Utils.Menu;

import static Asm1.Control.EnrollmentControl.COURSE_LIST;
import static Asm1.Control.EnrollmentControl.STUDENT_LIST;

public class Main {

    public static void main(String[] args) throws Exception{
        mainMenu();
    }
    public static void mainMenu() {
        System.out.println("============================== Student Enrollment Program =========================");
        STUDENT_LIST.print(STUDENT_LIST.getAll());
        COURSE_LIST.print(COURSE_LIST.getAll());

        Menu menu = new Menu("Menu");
        menu.addOption("Print all courses for 1 student in 1 semester", PrintControl::Printallcoursesfor1studentin1semester);
        menu.addOption("Print all students of 1 course in 1 semester", PrintControl::Printallstudentsof1coursein1semester);
        menu.addOption("Print all courses offered in 1 semester", PrintControl::Printallcoursesofferedin1semester);
        menu.addOption("Enroll a student for 1 semester",EnrollmentControl::CreateEnroll);
        menu.addOption("Update an enrolment of a student for 1 semester",EnrollmentControl::UpdateEnroll);
        menu.addOption("Delete an enrolment of a student for 1 semester",EnrollmentControl::DeleteEnroll);
        menu.addOption("Exit",()->{
            System.out.println("Exiting");
        });
        menu.start();
    }
}
