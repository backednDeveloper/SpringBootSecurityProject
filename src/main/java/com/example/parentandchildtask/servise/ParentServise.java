package com.example.parentandchildtask.servise;

import com.example.parentandchildtask.entity.ConfirmationTokenEntity;
import com.example.parentandchildtask.entity.ParentEntity;
import com.example.parentandchildtask.interface1.ParentInterface;
import com.example.parentandchildtask.repository.ConfirmationTokenRepository;
import com.example.parentandchildtask.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ParentServise implements ParentInterface {
    private final ParentRepository parentRepository;



    @Override
    public List<ParentEntity> getAllParent() {
        return parentRepository.getAllParent();
    }

    @Override
    public ParentEntity getParentById(int id) {
        return parentRepository.getParentById(id);
    }

    @Override
    public ParentEntity creatTeacher(ParentEntity parent) {
        return parentRepository.creatTeacher(parent);
    }

    @Override
    public ParentEntity delete(int id) {
        return parentRepository.delete(id);
    }

    @Override
    public ParentEntity updateById(ParentEntity parent, int id) {
        return parentRepository.updateById(parent, id);
    }


}
