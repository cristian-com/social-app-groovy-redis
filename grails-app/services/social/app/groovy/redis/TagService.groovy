package social.app.groovy.redis

import grails.gorm.transactions.Transactional
import org.apache.commons.lang3.StringUtils

@Transactional
class TagService {

    List<Tag> getTags(String text) {
        List<Tag> tags = [StringUtils.splitByWholeSeparator(text,"#", 2)].stream()
            .skip(1).map { it}.collect();

        return tags;
    }
}
