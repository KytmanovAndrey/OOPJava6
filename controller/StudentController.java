package ru.gb.oseminar.controller;

import ru.gb.oseminar.data.Student;
import ru.gb.oseminar.data.StudentGroup;
import ru.gb.oseminar.data.Teacher;
import ru.gb.oseminar.service.IStudentGroupService;
import ru.gb.oseminar.service.UserService;
import ru.gb.oseminar.view.StudentView;
import ru.gb.oseminar.view.UserView;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class StudentController implements UserController<Student>{

    private final UserService<Student> dataService;
    private final IStudentGroupService iStudentGroupService;
    private final UserView userView;

    public StudentController(UserService<Student> dataService, IStudentGroupService iStudentGroupService, UserView userView) {
        this.dataService = dataService;
        this.iStudentGroupService = iStudentGroupService;
        this.userView = userView;
    }

    @Override
    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        dataService.create(firstName, secondName, patronymic, dateOfBirth);
        userView.sendOnConsole(dataService.getAll());
    }

    public void createStudentGroup(StudentGroup studyGroup){
        iStudentGroupService.createStudentGroup(studyGroup);
        userView.sendOnConsoleUserGroup(iStudentGroupService.getStudentGroup());
    }

    public void getStudentInStudentGroup(String firstName, String secondName){
        Student student = iStudentGroupService.getStudentFromStudentGroup(firstName, secondName);
        userView.sendOnConsole(Collections.singletonList(student));
    }

    public void getSortedListStudentFromStudentGroup(){
        List<Student> students = iStudentGroupService.getSortedStudentGroup();
        userView.sendOnConsole(students);
    }

    public void getSortedListByFIOStudentFromStudentGroup(){
        List<Student> students = iStudentGroupService.getSortedByFIOStudentGroup();
        userView.sendOnConsole(students);
    }
}
