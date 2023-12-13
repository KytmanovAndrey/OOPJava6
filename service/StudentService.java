package ru.gb.oseminar.service;

import ru.gb.oseminar.data.Student;

import java.time.LocalDate;
import java.util.List;

public class StudentService implements UserService<Student> {

    private final List<Student> students;

    public StudentService(List<Student> students) {
        this.students = students;
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        Long countMaxId = 0L;
        for (Student student: students){
                if (student.getStudentId() > countMaxId){
                    countMaxId = student.getStudentId();
            }
        }
        countMaxId++;
        Student student = new Student(firstName, secondName, patronymic, dateOfBirth, countMaxId);
        students.add(student);
    }
}
