package rest.demo.grails.elastic.redis

import java.time.Instant

class Comment {

    UUID id = UUID.randomUUID()
    String content
    List<Tag> tags
    String author
    Instant instant

    static constraints = {
    }
}
