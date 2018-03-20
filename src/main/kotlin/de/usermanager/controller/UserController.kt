package de.usermanager.controller

import de.usermanager.viewModel.User
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/")
class UserController {

    @RequestMapping(value = "users", method = [(RequestMethod.GET)])
    fun list(): List<User> {
        return UserStub.list()
    }

    @RequestMapping(value = "users/{id}", method = [(RequestMethod.GET)])
    fun get(@PathVariable id: Long): User {
        return UserStub.get(id)
    }

    @RequestMapping(value = "users", method = [(RequestMethod.POST)])
    fun create(@RequestBody user: User): User {
        return UserStub.create(user)
    }

    @RequestMapping(value = "users/{id}", method = [(RequestMethod.PUT)])
    fun create(@PathVariable id: Long, @RequestBody user: User): User {
        return UserStub.update(id, user)
    }

    @RequestMapping(value = "users/{id}", method = [(RequestMethod.DELETE)])
    fun create(@PathVariable id: Long): User {
        return UserStub.delete(id)
    }
}

