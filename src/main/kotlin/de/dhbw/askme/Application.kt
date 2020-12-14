package de.dhbw.askme

import io.micronaut.runtime.Micronaut
import io.micronaut.runtime.Micronaut.*
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.info.*

@OpenAPIDefinition(
    info = Info(
        title = "Hello World",
        version = "0.0",
        description = "My API",
        license = License(name = "Apache 2.0", url = "https://foo.bar"),
        contact = Contact(url = "https://www.dhbw.de", name = "Joern", email = "joern@something")
    )
)
object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.run(Application.javaClass)
    }
}
