import common.AcceptanceTestHelper
import groovyx.net.http.RESTClient
import org.springframework.http.HttpStatus
import spock.lang.Requires
import spock.lang.Shared
import spock.lang.Specification

@Requires({ ['local', 'nonprod'].contains(System.properties['acceptanceEnv'] ?: 'local') })
class ApplicationAccSpec extends Specification {
    static final String env = System.properties['acceptanceEnv'] ?: 'local'

    @Shared
    RESTClient restClient

    @Shared
    AcceptanceTestHelper testHelper

    def setup() {
        testHelper = new AcceptanceTestHelper(env)
        restClient = new RESTClient(testHelper.targetHost)

        restClient.client.getParams().setParameter('http.connection.timeout', new Integer(5_000))
        restClient.client.params.setParameter('http.socket.timeout', new Integer(5_000))
    }

    def 'returns /skus/ response'() {
        when:
        def response = restClient.get([path: '/skus/foobar', headers: ["Accept": "application/json;charset=UTF-8"]])

        then:
        response.status == HttpStatus.OK.value
        response.data.skuId == "4PD811VPR0010"
    }
}