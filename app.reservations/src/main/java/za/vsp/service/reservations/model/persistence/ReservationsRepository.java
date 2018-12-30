package za.vsp.service.reservations.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.vsp.service.reservations.model.Site;

/**
 * ReservationsRepository.
 * (<a href="https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-creating-database-queries-from-method-names/">ReservationsRepository</a>)
 *
 * We can create query methods that use this strategy by following these rules:
 *
 * 1. The name of our query method must start with one of the following prefixes: find…By, read…By, query…By, count…By, and get…By.
 *
 * 2. If we want to limit the number of returned query results, we can add the First or the Top keyword before the first By word. If we want to get more than one result,
 * we have to append the optional numeric value to the First and the Top keywords. For example, findTopBy, findTop1By, findFirstBy, and findFirst1By all return the first
 * entity that matches with the specified search criteria.
 *
 * 3. If we want to select unique results, we have to add the Distinct keyword before the first By word. For example, findTitleDistinctBy or findDistinctTitleBy means
 * that we want to select all unique titles that are found from the database.
 *
 * 4. We must add the search criteria of our query method after the first By word. We can specify the search criteria
 * by combining <a href="http://docs.spring.io/spring-data/jpa/docs/1.8.x/reference/html/#repositories.query-methods.query-property-expressions">property expressions</a>
 * with the <a href="http://docs.spring.io/spring-data/jpa/docs/1.8.x/reference/html/#repository-query-keywords">supported keywords</a>.
 *
 * 5. If our query method specifies x search conditions, we must add x method parameters to it. In other words, the number of method parameters must be equal than the
 * number of search conditions. Also, the method parameters must be given in the same order than the search conditions.
 *
 *
 * @author <a href="mailto:ramon.fourie@epiuse.com">Ramon Fourie</a>
 * @version $Id: ReservationsRepository.java 595 2018-12-29 14:55:21Z fourier04 $
 */
@Repository
public interface ReservationsRepository extends JpaRepository<Site, Long> {

  Iterable<Site> findAllByRegion(final String region);
}
