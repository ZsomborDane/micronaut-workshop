package clubs

import clubs.domain.Club
import clubs.service.ClubService
import grails.gorm.transactions.Rollback
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@Rollback
@MicronautTest
class ClubServiceTest extends Specification {

    @Inject
    EmbeddedServer embeddedServer
    @Inject ClubService service

    void "it can work with clubs"() {
        expect:
        service.count() == 0

        when:
        service.save("Real Madrid CF", "Bernabeu")

        then:
        service.count() == 1

        when:
        List<Club> clubs = service.findAll()

        then:
        clubs.size() == 1
    }

    void "it can show a club"() {
        given:
        Club club = service.save("CD Leganes", "Butarque")

        when:
        service.find(club.id)

        then:
        club.name == "CD Leganes"
        club.stadium == "Butarque"
    }

}
