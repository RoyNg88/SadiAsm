package Asm1.Course;

import java.util.Objects;

public class Course {
    private int id;
    private String name;
    private String nof;


    public Course(int id, String name, String nof) {
        this.id = id;
        this.name = name;
        this.nof = nof;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNof() {
        return nof;
    }

    public void setNof(String nof) {
        this.nof = nof;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nof='" + nof + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && Objects.equals(name, course.name) && Objects.equals(nof, course.nof);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nof);
    }
}





