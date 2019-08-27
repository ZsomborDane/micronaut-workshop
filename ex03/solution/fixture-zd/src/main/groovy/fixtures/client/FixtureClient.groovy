package fixtures.client

import fixtures.view.FixtureView
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("/fixture")
interface FixtureClient {
    @Get("/")
    List<FixtureView> findAll()
}

