pipeline {
    agent any

    tools {
        maven 'Maven-3.9.11'   //usa EXACTAMENTE el nombre que pusiste en Jenkins → Global Tools
    }

    stages {

        stage('Clonar repositorio') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/prvgal/DevOps-Pipeline.git'
            }
        }

        stage('Compilar') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Ejecutar tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Empaquetar') {
            steps {
                sh 'mvn package'
            }
        }
    }

    post {
        success {
            echo "Pipeline completado exitosamente"
        }
        failure {
            echo "❌ Pipeline falló"
        }
    }
}
