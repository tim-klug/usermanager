package de.usermanager.controller.resources

data class UserResource(
        val firstName:String = "FirstName",
        val lastName:String = "LastName",
        val email:String = "email@domain.com"
    ) {}