package com.example.parentandchildtask.servise;

import com.example.parentandchildtask.entity.Child;
import com.example.parentandchildtask.interface1.ChildInterface;
import com.example.parentandchildtask.repository.ChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChildServise implements ChildInterface {
    private final ChildRepository repository;

    @Override
    public List<Child> getAllChild() {
        return repository.getAllChild();
    }

    @Override
    public Child getChildById(int id) {
        return repository.getChildById(id);
    }

    @Override
    public Child creatChild(Child child) {
        return repository.creatChild(child);
    }

    @Override
    public Child delete(int id) {
        return repository.delete(id);
    }

    @Override
    public Child updateById(Child child, int id) {
        return repository.updateById(child, id);
    }
}
