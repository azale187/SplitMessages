package splitMessages.services

import spock.lang.Specification
import spock.lang.Unroll

class SplitMessageServiceSpec extends Specification {

    SplitMessagesService service

    def setup() {
        service = new SplitMessagesService()
    }

    @Unroll
    def 'Split message: #message'() {

        when:
        def result = service.solution(message, length)

        then:
        result == expectedValue

        where:
        message                                              | length | expectedValue
        ''                                                   | 1      | -1
        'SOMELONGMESSAGE'                                    | 2      | -1
        'SMS messages are really short'                      | 12     | 3
        'SMS messages are really short'                      | 8      | 5
        "I turned myself into a pickle. I'm Pickle Riiiiick" | 4      | -1
        "I turned myself into a pickle. I'm Pickle Riiiiick" | 8      | 7
    }
}