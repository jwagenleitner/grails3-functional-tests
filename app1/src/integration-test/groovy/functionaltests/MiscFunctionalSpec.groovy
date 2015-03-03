package functionaltests

import grails.test.mixin.integration.Integration

import spock.lang.*
import geb.spock.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration(applicationClass=functionaltests.Application)
class MiscFunctionalSpec extends GebSpec {

    @Issue('GRAILS-12028')
    void "Test that when an action returns null the view is rendered by convention"() {
        when:
            go '/misc/actionWhichReturnsNull'

        then:
        	$('title').text() == 'Action Which Returns Null GSP'
    }
}