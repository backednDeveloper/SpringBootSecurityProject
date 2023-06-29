package com.example.parentandchildtask.interface1;


import com.example.parentandchildtask.entity.Child;

import java.util.List;

public interface ChildInterface {
    List<Child> getAllChild();

    Child getChildById(int id);

    Child creatChild(Child child);

    Child delete (int id);

    Child updateById(Child child, int id);
}
