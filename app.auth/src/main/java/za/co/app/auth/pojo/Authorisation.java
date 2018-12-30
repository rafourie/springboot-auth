package za.co.app.auth.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Authorisation implements Serializable {

  private List<String> roles = new ArrayList<>();

  public void addRole(final String role) {
    roles.add(role);
  }

  public List<String> getRoles() {
    return roles;
  }
}
