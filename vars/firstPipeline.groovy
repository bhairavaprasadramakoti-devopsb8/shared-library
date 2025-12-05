//@Library('com.i27academy.slb@main') _

import com.i27academy.builds.Calculator

def call(Map pipelineParams) {

    Calculator calculator = new Calculator(this)

    pipeline {
        agent {
            label 'java-slave'
        }

        environment {
            APPLICATION_NAME = "${pipelineParams.appName}"
        }

        stages {

            stage('Addition') {
                steps {
                    script {
                        echo "**** Calling add method from src folder ****"
                        echo "Addition Result: ${calculator.add(2, 3)}"
                    }
                }
            }

            stage('Build') {
                steps {
                    echo "****** Building the ${env.APPLICATION_NAME} application ******"
                }
            }

            stage('Test') {
                steps {
                    echo "****** Testing the ${env.APPLICATION_NAME} application ******"
                }
            }

            stage('DeploytoDev') {
                steps {
                    echo "****** Deploying the ${env.APPLICATION_NAME} application to dev environment ******"
                }
            }

            stage('DeploytoStage') {
                steps {
                    echo "****** Deploying the ${env.APPLICATION_NAME} application to Stage environment ******"
                }
            }

            stage('DeploytoProd') {
                steps {
                    echo "****** Deploying the ${env.APPLICATION_NAME} application to Prod environment ******"
                }
            }
        }
    }
}
