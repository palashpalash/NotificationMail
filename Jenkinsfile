pipeline {
    agent any

    environment {
        // Replace with your DockerHub username
        DOCKER_USER = 'Palash123567'
        // Your repo name
        REPO_NAME = 'my-springboot-app'
        //
        GIT_REPO_NAME="NotificationMail"
    }

    stages {


        stage('Build with Maven') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    def tagName = "${env.GIT_REPO_NAME}${env.BUILD_NUMBER}"
                    bat "docker build -t ${DOCKER_USER}/${REPO_NAME}:${tagName} ."
                }
            }
        }

        stage('Push to DockerHub') {
            steps {
                script {
                    def tagName = "${env.GIT_REPO_NAME}${env.BUILD_NUMBER}"
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                        bat """
                            echo %PASSWORD% | docker login -u %USERNAME% --password-stdin
                            docker push ${DOCKER_USER}/${REPO_NAME}:${tagName}
                        """
                    }
                }
            }
        }
    }

    post {
        success {
            echo "Docker image pushed successfully!"
        }
        failure {
            echo "Something went wrong..."
        }
    }
}
