package model;

public class Student {
    private String id;
    private String name;
    private String department;
    private double grade;

    public Student(String id, String name, String department, double grade) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.grade = grade;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public double getGrade() { return grade; }
    public void setGrade(double grade) { this.grade = grade; }

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Dept: %s, Grade: %.2f", id, name, department, grade);
    }
}
