package ru.gb.oseminar.view;

import ru.gb.oseminar.data.Student;
import ru.gb.oseminar.data.StudentGroup;

import java.util.List;
import java.util.logging.Logger;

public class StudentView implements UserView<Student, StudentGroup>{

    Logger logger;

    public StudentView(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void sendOnConsole(List<Student> students) {
        for(Student user: students){
            logger.info(user.toString());
        }
    }

    public void sendOnConsoleUserGroup(StudentGroup studentGroup){
        logger.info(studentGroup.toString());
    }

}
