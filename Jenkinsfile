pipeline {
    agent any

    tools {
        maven 'Maven-3.9.11'  
    }

    stages {

        stage('Clonar repositorio') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/prvgal/DevOps-Pipeline.git'
            }
        }

        stage('Construir (Build)') {
            steps {
                echo 'Compilando el proyecto...'
                sh "mvn -B clean compile"
            }
        }

        stage('Ejecutar tests') {
            steps {
                echo 'Ejecutando pruebas unitarias...'
                sh "mvn -B test"
            }
        }

        stage('Empaquetar') {
            steps {
                echo 'Generando archivo .jar...' 
                sh "mvn -B package"
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
        success {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
}
