package Asm1;

import Asm1.Control.EnrollmentControl;
import Asm1.Control.PrintControl;
import Asm1.Utils.Menu;


public class Main {

    public static void main(String[] args) {
        mainMenu();
    }
    public static void mainMenu() {

        Menu menu = new Menu("Menu");
        menu.addOption("Enroll Menu", EnrollmentControl::EnrollMenu);
        menu.addOption("Print Menu", PrintControl::PrintMenu);
        menu.addOption("List of student", EnrollmentControl::Showallstudent);
        menu.addOption("List of course", EnrollmentControl::Showallcourse);
        menu.addOption("Exit",()->{
            System.out.println("Exiting");
        });
        menu.start();
    }
}
