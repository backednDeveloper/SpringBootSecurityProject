package com.example.parentandchildtask.controller;

import com.example.parentandchildtask.entity.ChildEntity;
import com.example.parentandchildtask.interface1.ChildInterface;
import com.example.parentandchildtask.servise.ChildServise;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/child")
@RequiredArgsConstructor
public class ChildController implements ChildInterface {
    private final ChildServise servise;

    @GetMapping()
    @Override
    public List<ChildEntity> getAllChild() {
        return servise.getAllChild();
    }

    @GetMapping("/{id}")
    @Override
    public ChildEntity getChildById(@PathVariable int id) {
        return servise.getChildById(id);
    }

    @PostMapping()
    @Override
    public ChildEntity creatChild(@RequestBody ChildEntity child) {
        return servise.creatChild(child);
    }

    @DeleteMapping("/{id}")
    @Override
    public ChildEntity delete(@PathVariable int id) {
        return servise.delete(id);
    }

    @PutMapping()
    @Override
    public ChildEntity updateById(@RequestBody ChildEntity child, @PathVariable int id) {
        return servise.updateById(child, id);
    }
}
