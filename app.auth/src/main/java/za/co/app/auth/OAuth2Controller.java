package za.co.app.auth;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;*/
/*import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import za.co.app.auth.model.Customer;
import za.co.app.auth.model.CustomerDAO;*/

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.app.auth.pojo.Authorisation;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class OAuth2Controller {

  private static final Logger LOG = LoggerFactory.getLogger(OAuth2Controller.class);

  private static final Gson GSON = new GsonBuilder()
      .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
      .create();

  @PostMapping
  public String isAuthorised(final KeycloakAuthenticationToken token, @RequestBody final String body) {
    boolean authorised = true;
    LOG.info("isAuthorised for principal [{}]: {} ", token, body);
    Authorisation authorisationBean = GSON.fromJson(body, Authorisation.class);
    LOG.info("Roles extracted from request body: {}", authorisationBean.getRoles());
    List<String> roles = authorisationBean.getRoles();
    final Collection<GrantedAuthority> grantedAuthorities = token.getAuthorities();
    int rc = 0;
    while (authorised && rc < roles.size()) {
      final String requiredRole = "ROLE_" + roles.get(rc++);
      boolean reqRoleGranted = false;
      for (GrantedAuthority grantedAuthority : grantedAuthorities) {
        final String grantedAuthorityRole = grantedAuthority.getAuthority();
        LOG.info("Checking required role {} against granted role {}", requiredRole, grantedAuthorityRole);
        if (requiredRole.equals(grantedAuthorityRole)) {
          reqRoleGranted = true;
          break;
        }
      }
      LOG.info("Confirmed required role {} against granted roles: {}", requiredRole, reqRoleGranted);
      authorised &= reqRoleGranted;
    }
    return String.format("%s", authorised);
  }
}
