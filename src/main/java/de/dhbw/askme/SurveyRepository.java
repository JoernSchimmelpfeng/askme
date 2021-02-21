package de.dhbw.askme;

import de.dhbw.askme.domain.Survey;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.data.jdbc.runtime.JdbcOperations;
import javax.transaction.Transactional;
import java.sql.PreparedStatement;
import javax.inject.Inject;

/**
 * Abstract class of the DAO object to interact with the database
 *
 * This class is populated by Micronaut but you can add additional methods
 */
@Repository
@JdbcRepository
abstract public class SurveyRepository implements CrudRepository<Survey, Long>  {
}