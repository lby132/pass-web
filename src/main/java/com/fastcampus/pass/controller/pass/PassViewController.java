package com.fastcampus.pass.controller.pass;

import com.fastcampus.pass.service.pass.Pass;
import com.fastcampus.pass.service.pass.PassService;
import com.fastcampus.pass.service.user.User;
import com.fastcampus.pass.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/passes")
public class PassViewController {

    private final UserService userService;

    private final PassService passService;

    @GetMapping
    public ModelAndView getPasses(@RequestParam("userId") String userId, ModelAndView modelAndView) {
        //passes, user
        final List<Pass> passes = passService.getPasses(userId);
        final User user = userService.getUser(userId);

        modelAndView.addObject("passes", passes);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("pass/index");

        return modelAndView;
    }
}
