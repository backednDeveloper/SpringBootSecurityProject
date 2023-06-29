package com.example.parentandchildtask.interface1;

import com.example.parentandchildtask.entity.Parent;
import org.springframework.context.annotation.Lazy;

import java.util.List;
@Lazy
public interface ParentInterface {
    public List<Parent> getAllParent();
    public Parent getParentById(int id);
    public Parent creatTeacher(Parent parent);
    public  Parent delete(int id);
    public Parent updateById(Parent parent, int id);
}
