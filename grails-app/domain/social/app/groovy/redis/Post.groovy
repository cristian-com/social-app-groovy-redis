package social.app.groovy.redis

import java.time.Instant

class Post {
    UUID id = UUID.randomUUID()
    String title
    String content
    List<Tag> tags
    List<Comment> comments
    String author
    Instant instant

    static constraints = {

    }

}
