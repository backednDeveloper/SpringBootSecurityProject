package com.example.parentandchildtask.controller;


import com.example.parentandchildtask.entity.ParentEntity;
import com.example.parentandchildtask.interface1.ParentInterface;
import com.example.parentandchildtask.servise.ParentServise;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/v1/parent")

public class ParentController implements ParentInterface {
    private final ParentServise servise;

    @GetMapping
    @Override
    public List<ParentEntity> getAllParent() {
        log.atInfo().log("All parent has been showed");
        return servise.getAllParent();
    }

    @GetMapping("/{id}")
    @Override
    public ParentEntity getParentById(@PathVariable int id) {
        log.atInfo().log("Parent has been showed");
        return servise.getParentById(id);
    }

    @PostMapping("")
    @Override
    public ParentEntity creatTeacher(@RequestBody ParentEntity parent) {
        log.atInfo().log("Parent has been created");
        return servise.creatTeacher(parent);
    }

    @DeleteMapping("/{id}")
    @Override
    public ParentEntity delete(@PathVariable int id) {
        log.atInfo().log("Parent has been deleted");
        return servise.delete(id);
    }

    @PutMapping("")
    @Override
    public ParentEntity updateById(@RequestBody ParentEntity parent, @PathVariable int id) {
        log.atInfo().log("Parent has been update");
        return servise.updateById(parent, id);
    }

//    @PostMapping("/resigtration")
//    public ModelAndView registerUser(@RequestBody ModelAndView modelAndView, @RequestBody ParentEntity parentEntity) {
//        return servise.registerUser(modelAndView, parentEntity);
//    }
//
//    @PostMapping("/confirm")
//    public ModelAndView confirmUserAccount(@RequestBody ModelAndView modelAndView, @RequestBody String confirmationToken) {
//        return servise.confirmUserAccount(modelAndView, confirmationToken);
//    }

//    @PostMapping("/displayRegistration")
//    public ModelAndView displayRegistration(ModelAndView modelAndView, ParentEntity userEntity) {
//        return servise.displayRegistration(modelAndView, userEntity);
//    }
}
