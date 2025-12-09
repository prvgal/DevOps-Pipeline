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

        stage('Construir (Build)') {
            steps {
                echo 'Compilando el proyecto...'
                sh 'mvn clean compile'
            }
        }

        stage('Ejecutar tests') {
            steps {
                echo 'Ejecutando pruebas unitarias de la Iteración 1...'
                sh 'mvn test'
            }
        }

        stage('Empaquetar') {
            steps {
                echo 'Generando archivo .jar...'
                sh 'mvn package'
            }
        }
    }

    post {
        always {
            // Recogemos los resultados de los tests para verlos en Jenkins
            junit 'target/surefire-reports/*.xml'
        }
        success {
            echo '¡Iteración 1 completada con éxito!'
            // Guardamos el jar generado como artefacto
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
}
