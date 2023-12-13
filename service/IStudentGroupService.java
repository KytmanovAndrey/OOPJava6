package ru.gb.oseminar.service;

import ru.gb.oseminar.data.Student;
import ru.gb.oseminar.data.StudentGroup;
import ru.gb.oseminar.data.Teacher;

import java.util.List;

public interface IStudentGroupService {
    public void createStudentGroup(StudentGroup studentGroup);

    StudentGroup getStudentGroup();

    Student getStudentFromStudentGroup(String firstName, String secondName);

    List<Student> getSortedStudentGroup();

    List<Student> getSortedByFIOStudentGroup();
}
