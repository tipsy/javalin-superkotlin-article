package examples

import io.javalin.Javalin
import io.javalin.LogLevel
import io.javalin.embeddedserver.jetty.EmbeddedJettyFactory
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.ServerConnector
import org.eclipse.jetty.util.thread.QueuedThreadPool

fun main(args: Array<String>) {
    val app = Javalin.create().apply {
        embeddedServer(EmbeddedJettyFactory {
            Server(QueuedThreadPool(200, 8, 120_000)).apply {
                connectors = arrayOf(ServerConnector(server).apply {
                    port = 7070
                    idleTimeout = 120_000
                })
            }
        })
        requestLogLevel(LogLevel.EXTENSIVE) // this has been added
    }.start()
}
