package de.usermanager.controller

import de.usermanager.controller.resources.UserResource
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/users")
class UserController {

    @RequestMapping(value = "/", method = [(RequestMethod.GET)])
    fun list(): List<UserResource> {
        return UserStub.list()
    }

    @RequestMapping(value = "/{id}", method = [(RequestMethod.GET)])
    fun get(@PathVariable id: Long): UserResource {
        return UserStub.get(id)
    }

    @RequestMapping(value = "/", method = [(RequestMethod.POST)])
    fun create(@RequestBody userResource: UserResource): UserResource {
        return UserStub.create(userResource)
    }

    @RequestMapping(value = "/{id}", method = [(RequestMethod.PUT)])
    fun create(@PathVariable id: Long, @RequestBody userResource: UserResource): UserResource {
        return UserStub.update(id, userResource)
    }

    @RequestMapping(value = "/{id}", method = [(RequestMethod.DELETE)])
    fun create(@PathVariable id: Long): UserResource {
        return UserStub.delete(id)
    }
}

