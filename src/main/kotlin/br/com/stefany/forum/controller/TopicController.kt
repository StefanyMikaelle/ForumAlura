package br.com.stefany.forum.controller

import br.com.stefany.forum.dto.TopicForm
import br.com.stefany.forum.dto.TopicView
import br.com.stefany.forum.dto.UpdateTopicForm
import br.com.stefany.forum.service.TopicService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topic")
class TopicController (
    private val service : TopicService
) {

    @GetMapping
    fun list() : List<TopicView> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun findById (@PathVariable id: Long): TopicView {
        return service.findById(id)
    }

    @PostMapping
    fun create(
        @RequestBody @Valid form: TopicForm,
        uriBuilder: UriComponentsBuilder
    ) : ResponseEntity<TopicView>{
        val topicView = service.create(form)
        val uri = uriBuilder.path("/topic/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    fun update(@RequestBody @Valid form: UpdateTopicForm) : ResponseEntity<TopicView> {
        val topicView = service.update(form)
        return  ResponseEntity.ok(topicView)
    }

    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id : Long){
        service.delete(id)
    }

}