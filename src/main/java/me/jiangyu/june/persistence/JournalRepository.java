package me.jiangyu.june.persistence;

import me.jiangyu.june.domain.Journal;
import me.jiangyu.june.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * jiangyukun on 2015/6/10.
 */
@Repository
public class JournalRepository {
    @PersistenceContext(unitName = "Unit1")
    private EntityManager entityManager;

    public void save(Journal journal) {
        entityManager.persist(journal);
    }
}
