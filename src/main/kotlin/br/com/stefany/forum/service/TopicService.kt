package br.com.stefany.forum.service

import br.com.stefany.forum.dto.TopicForm
import br.com.stefany.forum.dto.TopicView
import br.com.stefany.forum.dto.UpdateTopicForm
import br.com.stefany.forum.exception.NotFoundException
import br.com.stefany.forum.mapper.TopicFormMapper
import br.com.stefany.forum.mapper.TopicViewMapper
import br.com.stefany.forum.model.Topic
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicService (
    private var topic : List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper : TopicFormMapper,
    private val notFoundMessage : String = "Topic not found"
){

    fun list(): List<TopicView> {
        return topic.stream().map {
            t -> topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun findById(id: Long): TopicView {
        val topicNew = find(id)
        return topicViewMapper.map(topicNew)
    }

    fun create(form: TopicForm) : TopicView{
        val topicAux = topicFormMapper.map(form)
        topicAux.id = topic.size.toLong() + 1
        topic = topic.plus(topicAux)
        return topicViewMapper.map(topicAux)
    }

    fun update(form: UpdateTopicForm) : TopicView {
        val topicOld = find(form.id)
        val topicNew = Topic(
            id = form.id,
            title = form.title,
            message = form.message,
            user = topicOld.user,
            course = topicOld.course,
            answer = topicOld.answer,
            status = topicOld.status,
            dateCreated = topicOld.dateCreated
        )
        topic = topic.minus(topicOld).plus(topicNew)
        return topicViewMapper.map(topicNew)
    }

    fun delete(id : Long) {
        val topicOld = find(id)
        topic = topic.minus(topicOld)
    }



    fun find (id: Long) : Topic{
        println("Buscando tópico com ID: $id")
        return  topic.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{
            println("Tópico não encontrado!")
            NotFoundException(notFoundMessage)
        }
    }

}