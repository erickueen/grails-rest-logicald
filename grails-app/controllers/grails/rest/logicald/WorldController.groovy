package grails.rest.logicald

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class WorldController {

    WorldService worldService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond worldService.list(params), model:[worldCount: worldService.count()]
    }

    def show(Long id) {
        respond worldService.get(id)
    }

    def save(World world) {
        if (world == null) {
            render status: NOT_FOUND
            return
        }

        try {
            worldService.save(world)
        } catch (ValidationException e) {
            respond world.errors, view:'create'
            return
        }

        respond world, [status: CREATED, view:"show"]
    }

    def update(World world) {
        if (world == null) {
            render status: NOT_FOUND
            return
        }

        try {
            worldService.save(world)
        } catch (ValidationException e) {
            respond world.errors, view:'edit'
            return
        }

        respond world, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        worldService.delete(id)

        render status: NO_CONTENT
    }
}
