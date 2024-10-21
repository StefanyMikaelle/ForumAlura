package br.com.stefany.forum.model

import java.time.LocalDateTime

data class Topic(
    val id: Long? = null,
    val title : String,
    val message : String,
    val dateCreated : LocalDateTime = LocalDateTime.now(),
    val course : Course,
    val user : User,
    val status : StatusTopic = StatusTopic.NOT_ANSWERED,
    val answer : List<Answer> = ArrayList()
)
