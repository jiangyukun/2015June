package me.jiangyu.june.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jiangyukun on 2015/6/2.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping({"/", "index"})
    public void index() {
    }

}
