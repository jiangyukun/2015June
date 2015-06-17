package me.jiangyu.june.service;

import me.jiangyu.june.domain.Journal;
import me.jiangyu.june.domain.User;
import me.jiangyu.june.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * jiangyukun on 2015/6/10.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JournalService journalService;

    @Transactional
    public void save(User user) throws Exception {
        userRepository.save(user);
        Journal journal = new Journal(String.valueOf(Math.random() * 10000), "1", "a");
        try {
            journalService.save(journal);
        } catch (Exception e) {
        }
    }

}
