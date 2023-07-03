package com.example.parentandchildtask.servise;

import com.example.parentandchildtask.entity.ConfirmationTokenEntity;
import com.example.parentandchildtask.entity.ParentEntity;
import com.example.parentandchildtask.repository.ConfirmationTokenRepository;
import com.example.parentandchildtask.repository.Parentrepository2;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ParentServive2 {
    private final Parentrepository2 parentRepository;
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final EmailServise emailServise;

    public ModelAndView registerUser(ModelAndView modelAndView, ParentEntity parentEntity) {

        Optional<ParentEntity> existingUser = parentRepository.findByEmail(parentEntity.getEmail_id());
        if (existingUser != null) {
            modelAndView.addObject("message", "This email already exists!");
            modelAndView.setViewName("Available profile");
        } else {
            parentRepository.save(parentEntity);
            ConfirmationTokenEntity confirmationToken = new ConfirmationTokenEntity(parentEntity);
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
        ConfirmationTokenEntity token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
        if(token != null){
            Optional<ParentEntity> parent = parentRepository.findByEmail(token.getParent().getEmail_id());
            parent.stream();
            parent.ifPresent(parent1 -> parentRepository.save(parent1));
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
