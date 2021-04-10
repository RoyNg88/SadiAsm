package Test;

import Asm1.Control.EnrollmentControl;
import Asm1.Course.Course;
import Asm1.Course.CourseList;
import Asm1.ManagesStudentEnrolment.StudentEnrollmentManager;
import Asm1.ManagesStudentEnrolment.StudentEnrolment;
import Asm1.Student.Student;
import Asm1.Student.StudentList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testing {

    private static StudentEnrollmentManager studentEnrolmentManager;
    private static StudentList studentList;
    private static CourseList courseList;

    @BeforeEach
    public void setUp() {
        studentEnrolmentManager = new EnrollmentControl();
        studentList = new StudentList();
        courseList = new CourseList();
    }

    @Test
    public void testEnrolmentIdWhenAddNew() {
        Student student = studentList.getOne(1);
        Course course = courseList.getOne(1);
        String semester = "2021A";
        studentEnrolmentManager.add(new StudentEnrolment(student, course, semester));
        assertEquals(1, studentEnrolmentManager.getOne(1).getId());
    }

    @Test
    public void testEnrolmentStudentNameWhenAddNew() {
        Student student = studentList.getOne(1);
        Course course = courseList.getOne(1);
        String semester = "2021A";
        studentEnrolmentManager.add(new StudentEnrolment(student, course, semester));
        StudentEnrolment enrolment = studentEnrolmentManager.getOneByStudentAndCourseAndSemester(student.getId(), course.getId(), semester);
        assertEquals("Roy Nguyen", enrolment.getStudent().getName());
    }

    @Test
    public void testEnrolmentCourseNameWhenAddNew() {
        Student student = studentList.getOne(1);
        Course course = courseList.getOne(1);
        String semester = "2021A";
        studentEnrolmentManager.add(new StudentEnrolment(student, course, semester));
        StudentEnrolment enrolment = studentEnrolmentManager.getOneByStudentAndCourseAndSemester(student.getId(), course.getId(), semester);
        assertEquals("Sadi", enrolment.getCourse().getName());
    }

    @Test
    public void testEnrolmentCourseNameWhenUpdate() {
        Student student = studentList.getOne(1);
        Course course = courseList.getOne(1);
        String semester = "2021A";
        studentEnrolmentManager.add(new StudentEnrolment(student, course, semester));
        StudentEnrolment enrolment = studentEnrolmentManager.getOneByStudentAndCourseAndSemester(student.getId(), course.getId(), semester);
        enrolment.setCourse(courseList.getOne(1));
        studentEnrolmentManager.update(enrolment.getId(), enrolment);
        StudentEnrolment newEnrolment = studentEnrolmentManager.getOne(enrolment.getId());
        assertEquals("Sadi", newEnrolment.getCourse().getName());
    }

    @Test
    public void testEnrolmentWhenDelete() {
        Student student = studentList.getOne(1);
        Course course = courseList.getOne(1);
        String semester = "2021A";
        studentEnrolmentManager.add(new StudentEnrolment(student, course, semester));
        studentEnrolmentManager.deleteByCourseId(1);
        StudentEnrolment enrolment = studentEnrolmentManager.getOneByStudentAndCourseAndSemester(student.getId(), course.getId(), semester);
        assertEquals(null, enrolment);
    }
}
