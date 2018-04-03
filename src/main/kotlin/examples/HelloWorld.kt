package examples

import io.javalin.Javalin

fun main(args: Array<String>) {
    val app = Javalin.start(7000) // create and start a server
    app.get("/") { ctx -> ctx.result("Hello World") } // add a handler to `/`
}
