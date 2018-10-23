pipeline {
    agent any
    options {
        // Only keep the 10 most recent builds
        buildDiscarder(logRotator(numToKeepStr:'10'))
    }
    stages {
        stage('Setup') {
            steps {
                githubOrganizationSetup()
            }
        }
        stage('Build and Scan') {
            steps {
                parallel (
                    build: {
                        nebulaGradleBuild()
                        dockerImageBuild()
                    },
                    scan: {
                        checkmarxScan()
                    }
                )
            }
            post {
                always {
                    echo "Built Version: ${env['VERSION']}"
                }
            }
        }
        stage('Publish') {
            steps {
                dockerImagePublish()
            }
        }
        stage('Deploy to Swarm') {
            steps {
                deployToSwarmNonProd()
            }
        }
    }
    post {
        always {
            junit "build/test-results/**/*.xml"
        }
        changed {
            buildNotification()
        }
    }
}
