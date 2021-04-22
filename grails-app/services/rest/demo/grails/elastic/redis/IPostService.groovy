package rest.demo.grails.elastic.redis

interface IPostService {

    Post get(String id)

    Post save(Post cc)

}
