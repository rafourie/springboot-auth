package com.sb.user.model;

/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;*/
import java.io.Serializable;
import java.util.Date;

/*@Entity*/
public class System implements Serializable {

  /*@Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")*/
  private long id;

  private String name;

  private Date lastaudit;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Date getLastaudit() {
    return lastaudit;
  }

  public void setLastaudit(Date lastaudit) {
    this.lastaudit = lastaudit;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String toString(){
    return id+" | " + name+ " | "+ lastaudit;
  }

}
