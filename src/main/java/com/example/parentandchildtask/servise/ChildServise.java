package com.example.parentandchildtask.servise;

import com.example.parentandchildtask.entity.ChildEntity;
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
    public List<ChildEntity> getAllChild() {
        return repository.getAllChild();
    }

    @Override
    public ChildEntity getChildById(int id) {
        return repository.getChildById(id);
    }

    @Override
    public ChildEntity creatChild(ChildEntity child) {
        return repository.creatChild(child);
    }

    @Override
    public ChildEntity delete(int id) {
        return repository.delete(id);
    }

    @Override
    public ChildEntity updateById(ChildEntity child, int id) {
        return repository.updateById(child, id);
    }
}
