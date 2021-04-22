package rest.demo.grails.elastic.redis

import java.time.Instant

class Post {
    String id = UUID.randomUUID()
    String title
    String content
    List<Tag> tags
    List<Comment> comments
    String author
    Instant instant = Instant.now()

    static constraints = {
    }

}
