package functionaltests


import grails.test.mixin.integration.Integration
import grails.transaction.*

import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration
@Rollback
class BookIntegrationSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "create book and save"() {
        given:
        def book = new Book(title:"The Stand")
        when:
        book.save(flush: true)

        then:
        Book.list()?.size() == 1
    }

    void "test transaction rolled back from previous test"() {
        expect:
            Book.count() == 0
    }
}