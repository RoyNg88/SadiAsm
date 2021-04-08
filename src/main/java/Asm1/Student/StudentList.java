package Asm1.Student;

import dnl.utils.text.table.TextTable;

import java.util.Arrays;
import java.util.List;

public class StudentList {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Roy Nguyen", "24-01-1999" ),
            new Student(2, "Tram Le", "22-09-2000" ),
            new Student(3, "Duc Nguyen", "10-09-2000"),
            new Student(4, "Thinh Nguyen", "10-12-2000"),
            new Student(5, "Binh Vuong", "18-05-1999")
    );

    public List<Student> getAll() {
        return STUDENTS;
    }

    public Student getOne(int studentId) {
        return STUDENTS.stream()
                .filter(student -> student.getId() == studentId)
                .parallel()
                .findAny()
                .orElse(null);
    }

    public void print(List<Student> students) {
        System.out.println("    *** List of students ***   ");
        String[] headers = new String[] {"Student Id", "Student Name", "Birthday"};
        Object[][] data = new Object[students.size()][headers.length];
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            data[i][0] = student.getId();
            data[i][1] = student.getName();
            data[i][2] = student.getBirthdate();
        }
        TextTable tt = new TextTable(headers, data);
        tt.printTable();
    }
}