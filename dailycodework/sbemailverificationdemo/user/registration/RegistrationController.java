package com.dailycodework.sbemailverificationdemo.user.registration;

import com.dailycodework.sbemailverificationdemo.event.RegistrationCompleteEvent;
import com.dailycodework.sbemailverificationdemo.user.User;
import com.dailycodework.sbemailverificationdemo.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {

    private final UserService userService;
    private final ApplicationEventPublisher publisher;

    @PostMapping
    public String registerUser(RegistrationRequest registrationRequest, final HttpServletRequest request){
        User user = userService.registerUser(registrationRequest);
        // publish registration event
        publisher.publishEvent(new RegistrationCompleteEvent(user,applicationUrl(request)));

        return "Succes! Please Check Your Email To Complete Your Registration";
    }


    public String applicationUrl(HttpServletRequest request) {
        return "http://"+request.getServerName()+";"+request.getServerPort()+request.getContextPath();
    }
}
