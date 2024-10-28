package br.com.stefany.forum.service

import br.com.stefany.forum.model.Course
import br.com.stefany.forum.model.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService (var user : List<User> ){
    init {
        val user1 = User(
            id = 1,
            name = "Stefany",
            email = "stefany_mikaelle@hotmail.com"
        )
        user = Arrays.asList(user1)
    }

    fun findById(id : Long) : User {
        return user.stream().filter({
                c -> c.id == id
        }).findFirst().get()
    }

}