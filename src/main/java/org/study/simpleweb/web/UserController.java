package org.study.simpleweb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by haoyuewen on 8/30/14.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
