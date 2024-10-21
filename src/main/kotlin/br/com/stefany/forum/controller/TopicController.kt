package br.com.stefany.forum.controller

import br.com.stefany.forum.model.Course
import br.com.stefany.forum.model.StatusTopic
import br.com.stefany.forum.model.Topic
import br.com.stefany.forum.model.User
import br.com.stefany.forum.service.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/topic")
class TopicController (
    private val service : TopicService
) {

    @GetMapping
    fun list() : List<Topic> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun findById (@PathVariable id: Long): Topic {
        return service.findById(id)
    }

}