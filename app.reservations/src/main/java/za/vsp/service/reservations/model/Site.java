package za.vsp.service.reservations.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Site {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String region;

  private String siteId;

  private boolean gsm;

  private boolean g3;

  private boolean lte;

  private String proposedSiteName;

  private String status;

  private String date;

  private String user;

  public Site() { }

  public Site(final String region, final String siteId, final boolean gsm, final boolean g3, final boolean lte,
              final String proposedSiteName, final String status, final String date, final String user) {
    this.region = region;
    this.siteId = siteId;
    this.gsm = gsm;
    this.g3 = g3;
    this.lte = lte;
    this.proposedSiteName = proposedSiteName;
    this.status = status;
    this.date = date;
    this.user = user;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getSiteId() {
    return siteId;
  }

  public void setSiteId(String siteId) {
    this.siteId = siteId;
  }

  public boolean isGsm() {
    return gsm;
  }

  public void setGsm(boolean gsm) {
    this.gsm = gsm;
  }

  public boolean isG3() {
    return g3;
  }

  public void setG3(boolean g3) {
    this.g3 = g3;
  }

  public boolean isLte() {
    return lte;
  }

  public void setLte(boolean lte) {
    this.lte = lte;
  }

  public String getProposedSiteName() {
    return proposedSiteName;
  }

  public void setProposedSiteName(String proposedSiteName) {
    this.proposedSiteName = proposedSiteName;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }
}
