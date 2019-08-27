package fixtures.init

import fixtures.domain.Fixture
import fixtures.service.FixtureService
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import io.micronaut.context.annotation.Requires
import io.micronaut.context.env.Environment
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.runtime.server.event.ServerStartupEvent

import javax.inject.Singleton

@Slf4j
@Singleton
@Requires(notEnv = Environment.TEST)
class DataLoader implements ApplicationEventListener<ServerStartupEvent> {


    final FixtureService fixtureService

    DataLoader(FixtureService fixtureService) {
        this.fixtureService = fixtureService
    }

    @Override
    void onApplicationEvent(ServerStartupEvent event) {
        if (!fixtureService.count()) {
            log.debug "Loading sample data"

            Fixture fixture
            //FIXME something wrong with Short
            fixture = new Fixture(homeClubId: 1, awayClubId: 2, homeScore: 5, awayScore: 0, date: new Date())

            fixtureService.save(fixture)
        }
    }
}