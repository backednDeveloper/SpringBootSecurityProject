package com.example.parentandchildtask.servise;

import com.example.parentandchildtask.entity.Parent;
import com.example.parentandchildtask.interface1.ParentInterface;
import com.example.parentandchildtask.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ParentServise implements ParentInterface {
    private final ParentRepository repository;
    @Override
    public List<Parent> getAllParent() {
        return repository.getAllParent();
    }

    @Override
    public Parent getParentById(int id) {
        return repository.getParentById(id);
    }

    @Override
    public Parent creatTeacher(Parent parent) {
        return repository.creatTeacher(parent);
    }

    @Override
    public  Parent delete (int id) {
        return repository.delete(id);
    }

    @Override
    public Parent updateById(Parent parent, int id) {
        return repository.updateById(parent,id);
    }
}
