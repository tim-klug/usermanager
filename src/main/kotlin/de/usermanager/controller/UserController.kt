package de.usermanager.controller

import de.usermanager.controller.resources.UserResource
import de.usermanager.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/users")
class UserController(
        @Autowired private val userService: UserService
) {

    @RequestMapping(value = ["/"], method = [(RequestMethod.GET)])
    fun list(): ResponseEntity<List<UserResource>> {
        return userService.findAll()
    }

    @RequestMapping(value = ["/{id}"], method = [(RequestMethod.GET)])
    fun get(@PathVariable id: Long): ResponseEntity<UserResource> {
        return userService.findById(id)
    }

    @RequestMapping(value = ["/"], method = [(RequestMethod.POST)])
    fun create(@RequestBody userResource: UserResource): UserResource {
        return UserStub.create(userResource)
    }

    @RequestMapping(value = ["/{id}"], method = [(RequestMethod.PUT)])
    fun create(@PathVariable id: Long, @RequestBody userResource: UserResource): UserResource {
        return UserStub.update(id, userResource)
    }

    @RequestMapping(value = ["/{id}"], method = [(RequestMethod.DELETE)])
    fun create(@PathVariable id: Long): UserResource {
        return UserStub.delete(id)
    }
}

