package me.jiangyu.june.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * jiangyukun on 2015/6/10.
 */
@Entity
@Table(name = "_user")
public class User {
    private String id;
    private String name;
    private String mobile;

    public User() {
    }

    public User(String id, String name, String mobile) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
