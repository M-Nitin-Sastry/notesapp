pipeline {
    agent any

    stages {

        stage('Build Maven') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t notesapp .'
            }
        }
    }

    post {

        success {
            mail to: 'nitinsastrym@gmail.com',
            subject: 'Jenkins Build SUCCESS',
            body: 'Your NotesApp project build was successful.'
        }

        failure {
            mail to: 'nitinsastrym@gmail.com',
            subject: 'Jenkins Build FAILED',
            body: 'Your NotesApp project build failed.'
        }
    }
}