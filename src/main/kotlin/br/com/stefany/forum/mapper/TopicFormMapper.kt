package br.com.stefany.forum.mapper

import br.com.stefany.forum.dto.TopicForm
import br.com.stefany.forum.model.Topic
import br.com.stefany.forum.service.CourseService
import br.com.stefany.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper (
    private val courseService: CourseService,
    private val userService: UserService
) : Mapper<TopicForm, Topic> {
    override fun map(t: TopicForm): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.findById(t.idCourse),
            user = userService.findById(t.idUser)
        )
    }

}
