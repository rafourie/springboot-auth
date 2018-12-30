package za.vsp.service.reservations.pojo;

import java.io.Serializable;

public class SiteSearch implements Serializable {

  private String region;

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }
}
