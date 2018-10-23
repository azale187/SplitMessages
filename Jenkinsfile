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
        stage('Build') {
            steps {
                nebulaGradleBuild()
            }
            post {
                always {
                    echo "Built Version: \${env['VERSION']}"
                    junit 'build/test-results/**/*.xml'
                }
            }
        }
        stage('Publish') {
            steps {
                publishDockerImage()
            }
        }
        stage('Deploy to Swarm') {
            steps {
                deployToSwarmNonProd()
            }
        }
    }
    post {
        changed {
            buildNotification()
        }
    }
}