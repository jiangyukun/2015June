package me.jiangyu.june.web.controller;

import me.jiangyu.june.domain.Journal;
import me.jiangyu.june.domain.User;
import me.jiangyu.june.service.JournalService;
import me.jiangyu.june.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * jiangyukun on 2015/6/2.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserService userService;
    @Autowired
    private JournalService journalService;

    @RequestMapping({"/", "index"})
    public void index() {
    }

    @RequestMapping("tx")
    public void tx() throws Exception {
        User user = new User(String.valueOf(Math.random() * 10000), "11", "111");
        userService.save(user);
    }

    @RequestMapping("tx1")
    public void tx1() throws Exception {
        Journal journal = new Journal(String.valueOf(Math.random() * 10000), "1", "a");
        journalService.save(journal);
    }
}
