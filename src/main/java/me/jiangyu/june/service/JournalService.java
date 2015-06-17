package me.jiangyu.june.service;

import me.jiangyu.june.domain.Journal;
import me.jiangyu.june.persistence.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * jiangyukun on 2015/6/10.
 */
@Service
public class JournalService {
    @Autowired
    private JournalRepository journalRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Journal journal) throws Exception {
        journalRepository.save(journal);
        throw new RuntimeException("xxx");
    }

}
