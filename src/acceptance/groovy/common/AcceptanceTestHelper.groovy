package common

class AcceptanceTestHelper {
    Map environmentConfig =
            [
                    local  : [targetHost: 'http://localhost:8089'
                    ],
                    nonprod: [targetHost: 'https://bsb-fms-mock-service-np.bluestembrands.com'
                    ]
            ]

    String targetHost = environmentConfig.local.targetHost
    String env

    AcceptanceTestHelper(String env) {
        this.env = env
        if (environmentConfig.keySet().contains(env)) {
            targetHost = environmentConfig[env].targetHost
        }
        println '*** Target host ***' + targetHost
    }
}