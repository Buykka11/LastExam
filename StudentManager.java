package service;

import model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student searchStudentById(String id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void deleteStudentById(String id) {
        students.removeIf(s -> s.getId().equals(id));
    }

    public List<Student> getAllStudents() {
        return students;
    }
}
