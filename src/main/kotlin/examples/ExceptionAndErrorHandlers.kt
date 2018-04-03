package examples

import io.javalin.Javalin

fun main(args: Array<String>) {

    val somethingBad = true

    val app = Javalin.start(7000) // create and start a server

    app.get("/error") { ctx ->
        if (somethingBad) {
            ctx.status(500)
        }
    }

    app.exception(NullPointerException::class.java, { e, ctx ->
        // do something
        ctx.status(500)
    }).exception(RuntimeException::class.java, { e, ctx ->
        // do something
        ctx.status(500)
    })

    app.error(500) { ctx ->
        ctx.result("500 - Internal server error") // all 500s end up like this
    }

}


