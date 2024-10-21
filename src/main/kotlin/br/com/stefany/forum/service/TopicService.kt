package br.com.stefany.forum.service

import br.com.stefany.forum.model.Course
import br.com.stefany.forum.model.Topic
import br.com.stefany.forum.model.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicService (private var topic : List<Topic>){
    init {
        val topic1 = Topic(
            id = 1,
            title = "Kotlin Doubt",
            message = "Kotlin Variable",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programation"
            ),
            user = User(
                id = 1,
                name = "Stefany",
                email = "stefany_mikaelle@hotmial.com"
            )
        )
        val topic2 = Topic(
            id = 2,
            title = "Kotlin Doubt 2",
            message = "Kotlin Variable 2",
            course = Course(
                id = 2,
                name = "Kotlin 2",
                category = "Programation 2"
            ),
            user = User(
                id = 2,
                name = "Stefany",
                email = "stefany_mikaelle@hotmial.com"
            )
        )
        val topic3 = Topic(
            id = 3,
            title = "Kotlin Doubt 3",
            message = "Kotlin Variable 3",
            course = Course(
                id = 3,
                name = "Kotlin 3",
                category = "Programation 3"
            ),
            user = User(
                id = 3,
                name = "Stefany",
                email = "stefany_mikaelle@hotmial.com"
            )
        )
        topic = Arrays.asList(topic1,topic2, topic3)
    }
    fun list(): List<Topic> {
        return topic
    }

    fun findById(id: Long): Topic {
        return topic.stream().filter({
            t -> t.id == id
        }).findFirst().get()
    }

}