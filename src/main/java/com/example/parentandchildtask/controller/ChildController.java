package com.example.parentandchildtask.controller;

import com.example.parentandchildtask.entity.Child;
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
    public List<Child> getAllChild() {
        return servise.getAllChild();
    }

    @GetMapping("/{id}")
    @Override
    public Child getChildById(@PathVariable int id) {
        return servise.getChildById(id);
    }

    @PostMapping()
    @Override
    public Child creatChild(@RequestBody Child child) {
        return servise.creatChild(child);
    }

    @DeleteMapping("/{id}")
    @Override
    public Child delete(@PathVariable int id) {
        return servise.delete(id);
    }

    @PutMapping()
    @Override
    public Child updateById(@RequestBody Child child,@PathVariable int id) {
        return servise.updateById(child, id);
    }
}
