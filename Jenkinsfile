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
                // Utilisez une commande appropriée pour exécuter vos tests sous Windows
                bat 'run-tests.bat'  // Si vous avez un script batch pour exécuter les tests
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
