package rest.demo.grails.elastic.redis.post

import grails.validation.ValidationException
import rest.demo.grails.elastic.redis.IPostService
import rest.demo.grails.elastic.redis.Post

import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

class PostController {
    IPostService postService

    static responseFormats = ['json']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        respond postService.list(params), model: [postCount: 1]
    }

    def show(Long id) {
        Post post = postService.get(id)

        if (post.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond post.errors
            return
        }

        try {
            postService.save(post)
        } catch (ValidationException e) {
            respond post.errors
            return
        }

        respond post, [status: OK, view: "show"]
    }

    def save() {
        Post post = new Post(params)
        postService.save(post)

        if (post.hasErrors()) {
            respond post.errors
        }
    }

    @Transactional
    def update(Post post) {
        if (post == null) {
            render status: NOT_FOUND
            return
        }
        if (post.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond post.errors
            return
        }

        try {
            postService.save(post)
        } catch (ValidationException e) {
            respond post.errors
            return
        }

        respond post, [status: OK, view: "show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null || postService.delete(id) == null) {
            render status: NOT_FOUND
            return
        }

        render status: NO_CONTENT
    }
}
