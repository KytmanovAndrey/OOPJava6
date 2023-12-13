package ru.gb.oseminar.view;

import ru.gb.oseminar.data.StudentGroup;
import ru.gb.oseminar.data.User;

import java.util.List;

public interface UserView<T extends User, P extends StudentGroup>{
    void sendOnConsole(List<T> list);

    void sendOnConsoleUserGroup(P userGroup);
}
