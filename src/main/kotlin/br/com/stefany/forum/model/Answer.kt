package br.com.stefany.forum.model

import java.time.LocalDateTime

data class Answer (
    val id: Long?,
    val message : String,
    val dataCreated : LocalDateTime = LocalDateTime.now(),
    val user : User,
    val topic : Topic,
    val solution : Boolean
)
