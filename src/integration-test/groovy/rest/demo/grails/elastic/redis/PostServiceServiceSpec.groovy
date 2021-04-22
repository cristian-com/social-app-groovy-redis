package rest.demo.grails.elastic.redis

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import org.grails.datastore.mapping.core.Datastore
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

@Integration
@Rollback
class PostServiceServiceSpec extends Specification {

    PostServiceService postServiceService
    @Autowired Datastore datastore

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PostService(...).save(flush: true, failOnError: true)
        //new PostService(...).save(flush: true, failOnError: true)
        //PostService postService = new PostService(...).save(flush: true, failOnError: true)
        //new PostService(...).save(flush: true, failOnError: true)
        //new PostService(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //postService.id
    }

    void cleanup() {
        assert false, "TODO: Provide a cleanup implementation if using MongoDB"
    }

    void "test get"() {
        setupData()

        expect:
        postServiceService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<IPostService> postServiceList = postServiceService.list(max: 2, offset: 2)

        then:
        postServiceList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        postServiceService.count() == 5
    }

    void "test delete"() {
        Long postServiceId = setupData()

        expect:
        postServiceService.count() == 5

        when:
        postServiceService.delete(postServiceId)
        datastore.currentSession.flush()

        then:
        postServiceService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        IPostService postService = new IPostService()
        postServiceService.save(postService)

        then:
        postService.id != null
    }
}
