package br.com.stefany.forum.dto

data class TopicDtoForm (
    val title : String,
    val message : String,
    val idCourse : Long,
    val idUser : Long
)
