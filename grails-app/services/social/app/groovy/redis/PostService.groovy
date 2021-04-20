package social.app.groovy.redis

import grails.gorm.transactions.Transactional

@Transactional
class PostService {

    TagService tagService;

    Post get(String id) {
        Post.get(id)
    }

    void save(Post post) {
        (new Post()).addto
    }
}
