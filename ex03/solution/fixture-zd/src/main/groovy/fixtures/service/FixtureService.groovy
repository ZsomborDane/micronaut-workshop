package fixtures.service

import fixtures.clubs.Club
import fixtures.clubs.ClubsClient
import fixtures.domain.Fixture
import fixtures.view.FixtureView
import grails.gorm.services.Service
import io.reactivex.Maybe

import javax.inject.Inject
import javax.validation.Valid

@Service(Fixture)
abstract class FixtureService {

    @Inject
    ClubsClient clubsClient

    //GORM operations
    abstract Fixture save(@Valid Fixture fixture)

    abstract List<Fixture> findAll()

    abstract Number count()

    Maybe<FixtureView> toView(Fixture fixture) {
        Maybe.zip(clubsClient.findTeam(fixture.homeClubId), clubsClient.findTeam(fixture.awayClubId)) { Club homeClub, Club awayClub ->
            return new FixtureView(
                    date: fixture.date,
                    homeClubName: homeClub.name,
                    awayClubName: awayClub.name,
                    stadium: homeClub.stadium,
                    homeScore: fixture.homeScore,
                    awayScore: fixture.awayScore
            )
        } as Maybe<FixtureView>
    }
}