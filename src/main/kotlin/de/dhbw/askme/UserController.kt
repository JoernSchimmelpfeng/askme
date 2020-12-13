package de.dhbw.askme

import io.micronaut.http.annotation.Get
import de.dhbw.askme.domain.User
import io.micronaut.http.HttpHeaders
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import javax.validation.Valid
import io.micronaut.http.annotation.Post
import io.micronaut.http.MutableHttpHeaders
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Put
import org.slf4j.LoggerFactory
import java.net.URISyntaxException
import java.lang.RuntimeException
import java.net.URI
import javax.inject.Singleton

/**
 * Controller for the user REST API
 */
@Controller("/user")
@Singleton
class UserController(private val repository: UserRepository) {

    @Get("/{id}")
    fun show(id: Long): User {
        log.debug("Get user with id {}", id)
        return repository
            .findById(id)
            .orElse(null)
    }

    @Put("/{id}")
    fun update(@Body user: @Valid User): HttpResponse<*> {
        log.debug("Updating user {}", user)
        repository.update(user)
        return HttpResponse
            .noContent<Any>()
            .header(HttpHeaders.LOCATION, "mylocation")
    }

    @Get
    fun list(): Iterable<User> {
        log.debug("List all users")
        return repository.findAll()
    }

    @Post("/")
    fun save(@Body user: @Valid User): HttpResponse<User> {
        log.debug("Save user {}", user)
        val newUser = repository.save(user)
        return HttpResponse
            .created(newUser)
            .headers { headers: MutableHttpHeaders ->
                headers.location(
                    somelocation
                )
            }
    }

    private val somelocation: URI
        get() = try {
            URI("/somelocation")
        } catch (e: URISyntaxException) {
            throw RuntimeException(e)
        }

    @Delete("/{id}")
    fun delete(id: Long): HttpResponse<*> {
        log.debug("Deleting user {}", id)
        repository.deleteById(id)
        return HttpResponse.noContent<Any>()
    }

    @Delete("/")
    fun deleteAll(): HttpResponse<*> {
        log.debug("Deleting all user")
        repository.deleteAll()
        return HttpResponse.noContent<Any>()
    }

    companion object {
        private val log = LoggerFactory.getLogger(UserController::class.java)
    }
}