pipeline {
  agent any

  environment {
    // Nombre de imagen a crear
    IMAGE_NAME = "miapp"
    IMAGE_TAG  = "latest"
    // Credencial ID para GitHub (si la necesitas en el pipeline)
    GITHUB_TOKEN = credentials('github-token')
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Prepare') {
      steps {
        echo "Workspace: ${env.WORKSPACE}"
        sh 'ls -la || true'
      }
    }

    stage('Build (Maven)') {
      steps {
        // Si Jenkins tiene Maven configurado como tool, usa tool('maven-3.9') con sh "${MVN_HOME}/bin/mvn"
        // Aquí usamos el contenedor de maven si lo prefieres localmente -> pero este ejemplo usa comando mvn
        sh 'mvn -B -DskipTests=false clean package'
      }
      post {
        success { archiveArtifacts artifacts: 'target/*.jar', fingerprint: true }
      }
    }

    stage('Unit tests') {
      steps {
        sh 'mvn test'
      }
      post {
        always {
          junit 'target/surefire-reports/*.xml'
        }
      }
    }

    stage('Docker Build') {
      steps {
        // Requiere que Jenkins tenga acceso a docker (mount /var/run/docker.sock)
        sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
      }
    }

    stage('Docker Run') {
      steps {
        // Para evitar colisiones, parámetro --rm y nombre único
        sh "docker rm -f ${IMAGE_NAME} || true"
        sh "docker run -d --name ${IMAGE_NAME} -p 8081:8080 ${IMAGE_NAME}:${IMAGE_TAG}"
      }
    }

  }

  post {
    success {
      echo "Pipeline finalizado con éxito"
    }
    failure {
      echo "Pipeline FALLIDO"
    }
    always {
      // Limpieza opcional
      sh "docker images | head -n 5 || true"
    }
  }
}
