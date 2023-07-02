package com.example.parentandchildtask.interface1;

import com.example.parentandchildtask.entity.ParentEntity;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Lazy
public interface ParentInterface {
    public List<ParentEntity> getAllParent();
    public ParentEntity getParentById(int id);
    public ParentEntity creatTeacher(ParentEntity parent);
    public ParentEntity delete(int id);
    public ParentEntity updateById(ParentEntity parent, int id);
}
