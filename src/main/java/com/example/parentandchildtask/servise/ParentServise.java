package com.example.parentandchildtask.servise;

import com.example.parentandchildtask.entity.ConfirmationToken;
import com.example.parentandchildtask.entity.ParentEntity;
import com.example.parentandchildtask.interface1.ParentInterface;
import com.example.parentandchildtask.repository.ConfirmationTokenRepository;
import com.example.parentandchildtask.repository.ParentRepository;
import com.example.parentandchildtask.repository.Parentrepository2;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.ctc.wstx.shaded.msv_core.datatype.xsd.NumberType.save;

@Service
@RequiredArgsConstructor
public class ParentServise implements ParentInterface {
    private final EmailServise emailServise;
    private final Parentrepository2 parentrepository2;
    private final ParentRepository parentRepository;
    private final ConfirmationTokenRepository.confirmationTokenRepository confirmationTokenRepository;


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

    public ModelAndView registerUser(ModelAndView modelAndView, ParentEntity parentEntity) {

        ParentEntity existingUser = parentrepository2.findByEmailIdIgnoreCase(String.valueOf(parentEntity.getEmail_id()));
        if (existingUser != null) {
            modelAndView.addObject("message", "This email already exists!");
            modelAndView.setViewName("Available profile");
        } else {
            parentrepository2.save(parentEntity);
            ConfirmationToken confirmationToken = new ConfirmationToken(parentEntity);
            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(String.valueOf(parentEntity.getEmail_id()));
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("emilaze77@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
                    + "https://autohospitalaz.com/confirm-account?token=" + confirmationToken.getConfirmationToken());

            emailServise.sendEmail(mailMessage);

            modelAndView.addObject("emailId", parentEntity.getEmail_id());

            modelAndView.setViewName("Congratulation successfulregistration");
        }

        return modelAndView;
    }


    public ModelAndView confirmUserAccount(ModelAndView modelAndView, String confirmationToken) {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
        if(token != null){
            ParentEntity parent = parentrepository2.findByEmailIdIgnoreCase(String.valueOf(token.getParent().getEmail_id()));
            parent.setEnabled(true);
            parentrepository2.save(parent);
            modelAndView.setViewName("Account is verificated");
        }
        else {
            modelAndView.addObject("Message", "The link is not invalid or broken");
            modelAndView.setViewName("Error not found!");
        }
        return modelAndView;
    }
    public ModelAndView displayRegistration(ModelAndView modelAndView, ParentEntity userEntity)
    {
        modelAndView.addObject("userEntity", userEntity);
        modelAndView.setViewName("register");
        return modelAndView;
    }
}
