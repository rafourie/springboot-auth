package za.vsp.service.reservations;

import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import za.vsp.service.reservations.mapper.SiteMapper;
import za.vsp.service.reservations.model.Site;
import za.vsp.service.reservations.model.persistence.ReservationsRepository;
import za.vsp.service.reservations.pojo.Authorisation;
import za.vsp.service.reservations.pojo.SiteDto;
import za.vsp.service.reservations.pojo.SiteSearch;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationsController {

  private static final Logger LOG = LoggerFactory.getLogger(ReservationsController.class);

  private static final Gson GSON = new GsonBuilder()
      .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
      .create();

  private RestTemplate restTemplate;

  @Value("${spring.application.name}")
  private String name;

  @Autowired
  private ReservationsRepository reservationsRepository;


  public ReservationsController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  /**
   * As you are using spring boot web, jackson dependency is implicit and we do not have to define explicitly.
   *
   * And as you have annotated with @RestController there is no need to do explicit json conversion. Just return a
   * POJO and jackson serializer will take care of converting to json.
   *
   * @param siteSearch
   * @return
   */
  @PostMapping
  @HystrixCommand(fallbackMethod = "noOneHome")
  public ResponseEntity<?> fetchSitesByRegion(@RequestHeader(value="Authorization") final String authorisation,
                                          @RequestBody final SiteSearch siteSearch) {
    LOG.error("fetchSitesByRegion: {}", siteSearch.getRegion());
    LOG.info("fetchSitesByRegion: Authorization: {}", authorisation);
    final HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    final String token = authorisation.substring(6, authorisation.length());
    headers.setBearerAuth(token);
    final Authorisation authorisationBean = new Authorisation();
    authorisationBean.addRole("reservations");
    HttpEntity<String> request = new HttpEntity<>(GSON.toJson(authorisationBean), headers);

    String response = restTemplate.postForObject("http://auth/auth", request, String.class);
    LOG.error(String.format("http://auth/auth <- %s", response));

    boolean authorisedResponse = Boolean.parseBoolean(response);
    if (authorisedResponse) {
      Iterable<Site> sitesByRegion = reservationsRepository.findAllByRegion(siteSearch.getRegion());
      LOG.error(String.format("fetchSitesByRegion [%s]: [%s]", siteSearch.getRegion(), sitesByRegion));
      List<SiteDto> siteDtoList = SiteMapper.INSTANCE.sitesToSiteCollection(sitesByRegion);
      LOG.error(String.format("fetchSitesByRegion [%s], siteDtoList: [%s]", siteSearch.getRegion(), siteDtoList));
      return new ResponseEntity<>(siteDtoList, HttpStatus.OK);
    } else {
      return new ResponseEntity<>("UNAUTHORIZED", HttpStatus.UNAUTHORIZED);
    }
  }

  private ResponseEntity<?> noOneHome(final String authorisation, final SiteSearch siteSearch) {
    LOG.error("Hmm, looks like no one's home for fetchSitesByRegion [{}]! :(", siteSearch.getRegion());
    return new ResponseEntity<>("UNAUTHORIZED", HttpStatus.UNAUTHORIZED);
  }
}

/*LOG.error("http://chamber/chamber -> Test");
    ResponseEntity<String> chamberResponse = restTemplate
        .postForEntity("http://chamber/chamber", "Test", String.class);
    String chamberResponseBody = chamberResponse.getBody();
    LOG.error(String.format("http://chamber/chamber <- %s", chamberResponseBody));*/
/*ResponseEntity<String> response = restTemplate
        .postForEntity("http://auth/auth", "hoohaa", String.class);
    LOG.error("http://auth/auth -> hoohaa");*/

    /*String responseBody = response.getBody();
    LOG.error(String.format("http://auth/auth <- %s", responseBody));*/