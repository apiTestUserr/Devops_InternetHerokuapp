pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/apiTestUserr/Devops_InternetHerokuapp.git'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'run-tests.bat'  // Assurez-vous que le chemin est correct
            }
        }
        stage('Archive') {
            steps {
                echo 'Archiving artifacts and test results...'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
