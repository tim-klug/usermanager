package de.usermanager.controller

import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import de.usermanager.controller.resources.UserResource
import de.usermanager.service.UserService
import org.junit.Test
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class UserControllerTest {

    @Test
    fun list_HasData_ListsAllUser() {
        val users = ResponseEntity<List<UserResource>>(HttpStatus.OK)
        val userService = mock<UserService> {
            on { findAll() } doReturn (users)
        }
        val sut = UserController(userService)

        val result = sut.list()

        assertThat(result.statusCode).isSameAs(HttpStatus.OK)
        assertThat(result.hasBody()).isFalse()
    }

}