package fixtures

import fixtures.client.FixtureClient
import fixtures.domain.Fixture
import fixtures.service.FixtureService
import fixtures.view.FixtureView
import groovy.util.logging.Slf4j
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import spock.lang.AutoCleanup
import spock.lang.Specification

import javax.inject.Inject

@Slf4j
@MicronautTest
class FixtureControllerSpec extends Specification {

    @Inject @AutoCleanup EmbeddedServer embeddedServer
    @Inject FixtureClient client
    @Inject FixtureService fixtureService

    void "test index"() {
        given:
        Fixture fixture = new Fixture(homeClubId: 1, homeScore: 5, awayClubId: 2, awayScore: 0, date: new Date())
        log.debug(fixture.toString())
        fixtureService.save(fixture)
        log.debug(fixtureService.toString())

        when:
        List<FixtureView> views = client.findAll()

        then:
        views.first().homeClubName == "CD Leganes"
        views.first().awayClubName == "Getafe CF"

        cleanup:
        fixture.delete(flush: true)
    }
}
