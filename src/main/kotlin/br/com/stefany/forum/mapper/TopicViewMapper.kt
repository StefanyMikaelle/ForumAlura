package br.com.stefany.forum.mapper

import br.com.stefany.forum.dto.TopicView
import br.com.stefany.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper : Mapper<Topic, TopicView> {
    override fun map(t: Topic): TopicView {
        return TopicView (
            id = t.id,
            title = t.title,
            message = t.message,
            dataCriation = t.dateCreated,
            status = t.status
        )
    }

}