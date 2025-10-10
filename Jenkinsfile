pipeline {
    agent any

    environment {
        DOCKER_HUB_REPO = 'your-dockerhub-username/spe-sci-calc'
        PROJECT_DIR = '/home/varn03/Desktop/SPE-sci-calc'
        ANSIBLE_PLAYBOOK = "${PROJECT_DIR}/ansible/deploy.yml"
        ANSIBLE_INVENTORY = "${PROJECT_DIR}/ansible/inventory.ini"
        DOCKER_CREDENTIALS_ID = 'dockerhub-creds'   // Jenkins credentials ID
        GIT_REPO_URL = 'https://github.com/varnit-mittal/SPE-sci-calc.git'
        MAIL_RECIPIENTS = 'varnit03mittal@gmail.com'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Cloning repository...'
                git branch: 'main', url: "${GIT_REPO_URL}"
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    echo 'Building Docker image...'
                    sh 'docker-compose build'
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    echo 'Pushing image to Docker Hub...'
                    withCredentials([usernamePassword(credentialsId: "${DOCKER_CREDENTIALS_ID}", usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                        sh '''
                            echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                            docker-compose push
                        '''
                    }
                }
            }
        }

        stage('Deploy with Ansible') {
            steps {
                script {
                    echo 'Deploying using Ansible...'
                    sh """
                        ansible-playbook -i ${ANSIBLE_INVENTORY} ${ANSIBLE_PLAYBOOK}
                    """
                }
            }
        }
    }

    post {
        success {
            mail to: "${MAIL_RECIPIENTS}",
                 subject: "✅ Jenkins Pipeline SUCCESS: SPE Scientific Calculator",
                 body: "The pipeline executed successfully.\n\n✔ Repo: ${GIT_REPO_URL}\n✔ Image: ${DOCKER_HUB_REPO}\n✔ Deployed successfully on local system."
        }
        failure {
            mail to: "${MAIL_RECIPIENTS}",
                 subject: "❌ Jenkins Pipeline FAILURE: SPE Scientific Calculator",
                 body: "The pipeline failed.\nPlease check the Jenkins logs for more details.\n\nRepo: ${GIT_REPO_URL}"
        }
    }
}
