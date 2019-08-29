package fixtures

import fixtures.clubs.Club
import fixtures.clubs.ClubsApi
import io.micronaut.retry.annotation.Fallback
import io.reactivex.Maybe

@Fallback
class ClubsClientMock implements ClubsApi{
    @Override
    Maybe<Club> findTeam(Long id) {
        if (id == 1) {
            Maybe.just(new Club(name: "Real Madrid CF", stadium: "Santiago Bernabeu"))
        } else {
            Maybe.just(new Club(name: "FC Barcelona", stadium: "Coliseum"))
        }
    }
}
