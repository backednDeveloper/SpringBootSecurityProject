package com.example.parentandchildtask.controller;


import com.example.parentandchildtask.entity.Parent;
import com.example.parentandchildtask.interface1.ParentInterface;
import com.example.parentandchildtask.servise.ParentServise;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/parent")

public class ParentController implements ParentInterface {
    private final ParentServise servise;

    @GetMapping
    @Override
    public List<Parent> getAllParent() {
        return servise.getAllParent();
    }

    @GetMapping("/{id}")
    @Override
    public Parent getParentById(@PathVariable int id) {
        return servise.getParentById(id);
    }

    @PostMapping("")
    @Override
    public Parent creatTeacher(@RequestBody Parent parent) {
        return servise.creatTeacher(parent);
    }

    @DeleteMapping("/{id}")
    @Override
    public Parent delete(@PathVariable int id) {
        return servise.delete(id);
    }

    @PutMapping("")
    @Override
    public Parent updateById(@RequestBody Parent parent,@PathVariable int id) {
        return servise.updateById(parent, id);
    }
}
