package br.com.stefany.forum.service

import br.com.stefany.forum.model.Course
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService (var course : List<Course>) {

    init {
        val course1 = Course(
            id = 1,
            name = "Kotlin"
        )
        course = Arrays.asList(course1)
    }

    fun findById(id : Long) : Course {
        return course.stream().filter({
            c -> c.id == id
        }).findFirst().get()
    }



}
