package grails.rest.logicald

import gorm.logical.delete.LogicalDelete

class World implements LogicalDelete<World> {

    String field

    static constraints = {
    }
}
