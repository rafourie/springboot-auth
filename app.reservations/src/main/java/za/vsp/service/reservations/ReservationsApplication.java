package za.vsp.service.reservations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import za.vsp.service.reservations.model.Site;
import za.vsp.service.reservations.model.persistence.ReservationsRepository;

@SpringBootApplication
public class ReservationsApplication implements CommandLineRunner {

  private static final Logger LOG = LoggerFactory.getLogger(ReservationsApplication.class);

  @Autowired
  private ReservationsRepository reservationsRepository;

  public static void main(String[] args) {
    SpringApplication.run(ReservationsApplication.class);
  }

  @Override
  public void run(String... args) {
    Site site = new Site(
        "NGA",
        "1110",
        true,
        true,
        false,
        "Hotel School",
        "RESERVED",
        "07 NOV 2007",
        "(NETCON_LOAD)");

    reservationsRepository.save(site);
    LOG.error(String.format("Added site to repository [%s]", site));

    site = new Site(
        "NGA",
        "10161",
        true,
        false,
        false,
        "Cullinan",
        "RESERVED",
        "04 JUN 2008 ",
        "DANIEL KAMFER (KAMFERDA)");

    reservationsRepository.save(site);
    LOG.error(String.format("Added site to repository [%s]", site));

    site = new Site(
        "CEN",
        "52061",
        true,
        true,
        false,
        "Van Rooy",
        "RESERVED",
        "11 JUL 2009 ",
        "CHRISTO HALL (HALLC)");

    reservationsRepository.save(site);
    LOG.error(String.format("Added site to repository [%s]", site));

    site = new Site(
        "CEN",
        "53501",
        false,
        true,
        false,
        "Toekoms_Mob",
        "RESERVED",
        "18 AUG 2009",
        "JOHANNES VISSER (VISSERJ)");

    reservationsRepository.save(site);
    LOG.error(String.format("Added site to repository [%s]", site));

    site = new Site(
        "EAS",
        "10501",
        true,
        false,
        false,
        "GRAAFF-REINET_DCS",
        "RESERVED",
        "10 NOV 2008",
        "MARSHALL STEENBOK (STEENBOM)");

    reservationsRepository.save(site);
    LOG.error(String.format("Added site to repository [%s]", site));

    site = new Site(
        "EAS",
        "12641",
        true,
        true,
        true,
        "RocklandsChickens",
        "RESERVED",
        "13 OCT 2016",
        "JOSEPH TOBI (TOBIJO)");

    reservationsRepository.save(site);
    LOG.error(String.format("Added site to repository [%s]", site));

    site = new Site(
        "KZN",
        "1821",
        true,
        true,
        false,
        "Nkonkotho",
        "RESERVED",
        "15 JUN 2016",
        "NOMPUMELELO NYANDENI (NYANDENO)");

    reservationsRepository.save(site);
    LOG.error(String.format("Added site to repository [%s]", site));

    site = new Site(
        "KZN",
        "10721",
        true,
        false,
        false,
        "Doornspruit",
        "RESERVED",
        "12 FEB 2008",
        "BRAD PHILLIPS (PHILLIPSB)");

    reservationsRepository.save(site);
    LOG.error(String.format("Added site to repository [%s]", site));

    site = new Site(
        "LES",
        "11241",
        true,
        true,
        false,
        "Pioneer_Mall",
        "RESERVED",
        "26 AUG 2010",
        "DONNA KAMBARRAN (DONNAK)");

    reservationsRepository.save(site);
    LOG.error(String.format("Added site to repository [%s]", site));

    site = new Site(
        "LES",
        "80265",
        true,
        true,
        true,
        "Bayport_Phuthaditjhaba",
        "RESERVED",
        "06 SEP 2017",
        "NETWORKS (NETWORKS)");

    reservationsRepository.save(site);
    LOG.error(String.format("Added site to repository [%s]", site));

    site = new Site(
        "LIM",
        "11341",
        false,
        true,
        false,
        "Phalaborwa_Rugby_Club",
        "RESERVED",
        "08 OCT 2008",
        "JERRY LETSOALO (LETSOAJE)");

    reservationsRepository.save(site);
    LOG.error(String.format("Added site to repository [%s]", site));

    site = new Site(
        "LIM",
        "11481",
        true,
        true,
        false,
        "Bela Bela Adventure Carnival",
        "RESERVED",
        "27 OCT 2008",
        "DERRICK LEHARE (LEHAREDE)");

    reservationsRepository.save(site);
    LOG.error(String.format("Added site to repository [%s]", site));

    site = new Site(
        "MPU",
        "10781",
        true,
        true,
        false,
        "Leonardia",
        "RESERVED",
        "31 JUL 2014",
        "TJ SETLALE (SETLALTJ)");

    reservationsRepository.save(site);
    LOG.error(String.format("Added site to repository [%s]", site));

    site = new Site(
        "MPU",
        "12101",
        true,
        true,
        false,
        "The_Hippos",
        "RESERVED",
        "22 MAR 2016",
        "BRENDON BURDETT (BRENDONB)");

    reservationsRepository.save(site);
    LOG.error(String.format("Added site to repository [%s]", site));

    site = new Site(
        "SGC",
        "10301",
        true,
        true,
        false,
        "Thrupps_Illovo",
        "RESERVED",
        "08 JUL 2009",
        "STUART THOMPSON (THOMPSST)");

    reservationsRepository.save(site);
    LOG.error(String.format("Added site to repository [%s]", site));

    site = new Site(
        "SGC",
        "10301",
        true,
        true,
        true,
        "honedew_shopping_centre",
        "RESERVED",
        "15 NOV 2010",
        "CHARLES LAMOLA (LAMOLACH)");

    reservationsRepository.save(site);
    LOG.error(String.format("Added site to repository [%s]", site));

    site = new Site(
        "SGS",
        "12581",
        true,
        true,
        false,
        "Van_Riebeeck_Str",
        "RESERVED",
        "03 MAR 2010",
        "MOLEFE MAHLANGU (MAHLANGM)");

    reservationsRepository.save(site);
    LOG.error(String.format("Added site to repository [%s]", site));

    site = new Site(
        "SGS",
        "39321",
        true,
        true,
        true,
        "Lenasia_South_Ext_4",
        "RESERVED",
        "11 JUL 2016",
        "NHLUVUKO HLUNGWANA (HLUNGWANAN)");

    reservationsRepository.save(site);
    LOG.error(String.format("Added site to repository [%s]", site));

    site = new Site(
        "WES",
        "14921",
        true,
        true,
        true,
        "Claremont_Stn",
        "RESERVED",
        "26 MAY 2014",
        "ASHLEY BEELDERS (BEELDERA)");

    reservationsRepository.save(site);
    LOG.error(String.format("Added site to repository [%s]", site));

    site = new Site(
        "WES",
        "80045",
        false,
        true,
        true,
        "VB_Tradebridge_Healthbridge_Obs",
        "RESERVED",
        "05 SEP 2011",
        "PIERRE DU PLESSIS (DUPLESPI)");

    reservationsRepository.save(site);
    LOG.error(String.format("Added site to repository [%s]", site));
  }
}
