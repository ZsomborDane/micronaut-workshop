package clubs


import spock.lang.Specification

class GroovySpockDummyTest extends Specification {


    void givenTwoAndTwo_whenAdding_thenResultIsFour() {

        given:
        int left = 2
        int right = 2

        when:
        int result = left + right

        then:
        result == 4
    }

}
