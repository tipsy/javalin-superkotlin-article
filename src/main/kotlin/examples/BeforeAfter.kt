package examples

import io.javalin.Javalin

fun main(args: Array<String>) {
    val app = Javalin.start(7000) // create and start a server
    app.before { ctx ->
        // do something before every request
    }
    app.get("/test") { ctx ->
        // do something for GET to /test endpoint
    }
    app.after("/test") { ctx ->
        // do something after requests to /test
    }
}
