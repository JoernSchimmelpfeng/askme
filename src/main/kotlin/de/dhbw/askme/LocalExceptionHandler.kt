package de.dhbw.askme

import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpHeaders
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import java.lang.UnsupportedOperationException
import javax.inject.Singleton


@Produces
@Singleton
@Requires(classes = [UnsupportedOperationException::class, ExceptionHandler::class])
open class LocalExceptionHandler : ExceptionHandler<UnsupportedOperationException, HttpResponse<String>> {
    override fun handle(request: HttpRequest<*>?, exception: UnsupportedOperationException?): HttpResponse<String> {
        return HttpResponse.badRequest()
    }
}