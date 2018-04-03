package examples

import io.javalin.ApiBuilder.*
import io.javalin.Context
import io.javalin.Javalin

fun main(args: Array<String>) {
    val app = Javalin.start(7000) // create and start a server
    app.routes {
        path("users") {
            get(UserController::getAllUsers);
            post(UserController::createUser);
            path(":id") {
                get(UserController::getUser);
                patch(UserController::updateUser);
                delete(UserController::deleteUser);
            }
        }
    }
}

object UserController {
    fun getAllUsers(ctx: Context) {} // TODO: Implement function
    fun createUser(ctx: Context) {} // TODO: Implement function
    fun getUser(ctx: Context) {} // TODO: Implement function
    fun updateUser(ctx: Context) {} // TODO: Implement function
    fun deleteUser(ctx: Context) {} // TODO: Implement function
}

