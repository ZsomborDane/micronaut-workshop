package fixtures.view

import grails.gorm.annotation.Entity

@Entity
class FixtureView {

    String homeClubName
    String awayClubName

    String stadium

    Short homeScore
    Short awayScore

    Date date
}
