package me.jiangyu.june.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * jiangyukun on 2015/6/10.
 */
@Entity
@Table(name = "_journal")
public class Journal {
    private String id;
    private String title;
    private String content;

    public Journal() {
    }

    public Journal(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
