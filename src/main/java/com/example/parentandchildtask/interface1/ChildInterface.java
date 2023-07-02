package com.example.parentandchildtask.interface1;


import com.example.parentandchildtask.entity.ChildEntity;

import java.util.List;

public interface ChildInterface {
    List<ChildEntity> getAllChild();

    ChildEntity getChildById(int id);

    ChildEntity creatChild(ChildEntity child);

    ChildEntity delete (int id);

    ChildEntity updateById(ChildEntity child, int id);
}
