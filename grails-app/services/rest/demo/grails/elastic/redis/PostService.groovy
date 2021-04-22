package rest.demo.grails.elastic.redis

import grails.gorm.services.Service
import grails.gorm.transactions.Transactional
import org.apache.commons.lang3.StringUtils

@Service
@Transactional
abstract class PostService implements IPostService {

    Post get(String id) {
        Post.get(id)
    }

    Post save(Post post) {
        List<Tag> tags = [StringUtils.splitByWholeSeparator(post.getContent(),"#", 2)].stream()
                .skip(1).map { it}.collect();
        post.setTags(tags)

        return post.save()
    }
}
