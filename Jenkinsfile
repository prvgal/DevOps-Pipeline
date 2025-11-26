pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build with Maven') {
            steps {
                sh "mvn -B clean package"
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t miapp:latest ."
            }
        }

        stage('Run Docker Container') {
            steps {
                sh "docker run -d --rm --name miapp -p 8081:8080 miapp:latest"
            }
        }
    }
}
