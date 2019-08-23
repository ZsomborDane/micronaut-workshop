package fixtures.clubs

import io.micronaut.http.annotation.Get
import io.reactivex.Maybe

interface ClubsApi {
    @Get("/{id}")
    Maybe<Club> findTeam(Long id)
}