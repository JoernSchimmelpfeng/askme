package de.dhbw.askme

import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.info.*

@OpenAPIDefinition(
    info = Info(
        title = "AskMe",
        version = "0.1",
        description = "AskMe API documentation for students sample project",
        license = License(name = "Apache 2.0", url = "https://github.com/JoernSchimmelpfeng/askme/blob/master/LICENSE"),
        contact = Contact(url = "https://github.com/JoernSchimmelpfeng", name = "Joern Schimmelpfeng", email = "")
    )
)
object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.run(Application.javaClass)
    }
}
