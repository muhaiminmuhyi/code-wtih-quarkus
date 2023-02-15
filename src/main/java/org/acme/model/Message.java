package org.acme.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

//@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public Integer id_user;
    public Integer number;
    public Integer is_active;
    public String chat;
    public Date send_at;
}
