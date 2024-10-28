package br.com.stefany.forum.dto

import br.com.stefany.forum.model.StatusTopic
import java.time.LocalDateTime

data class TopicView (
    val id : Long?,
    val title : String,
    val message : String,
    val status : StatusTopic,
    val dataCriation : LocalDateTime
)
