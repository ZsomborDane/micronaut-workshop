package fixtures.controller

import fixtures.service.FixtureService
import fixtures.view.FixtureView
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get


@Controller("/fixture")
class FixtureController {

    FixtureService fixtureService

    FixtureController(FixtureService fixtureService) {
        this.fixtureService = fixtureService
    }
    @Get("/")
    List<FixtureView> findAll() {
        fixtureService.findAll().collect {
            fixtureService.toView(it).blockingGet()
        }
    }
}