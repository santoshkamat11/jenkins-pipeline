def CONTAINER_NAME="jenkins-pipeline"
def CONTAINER_TAG="latest"
def DOCKER_HUB_USER="santoshkamat11"
def PASSWORD = "police12@"
def HTTP_PORT="8090"





node{


	stage('SCM Checkout'){
  
    git 'https://github.com/santoshkamat11/jenkins-pipeline'
  
  }
  
   stage('Compile-Package'){
  
    bat 'mvn package'
  
  }
  
  stage('Image Build'){
        imageBuild(CONTAINER_NAME, CONTAINER_TAG)
    }
    
    stage('Push to Docker Registry'){
        withCredentials([usernamePassword(credentialsId: 'dockerHubAccount', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
            pushToImage(CONTAINER_NAME, CONTAINER_TAG, USERNAME, PASSWORD)
        }
    }
    

}


def imageBuild(containerName, tag){
    def dockerHome = tool name: 'docker-1', type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
    bat "${dockerHome}/bin/docker build -t $containerName:$tag  -t $containerName --pull --no-cache ."
    echo "Image build complete"
}

def pushToImage(containerName, tag, dockerUser, dockerPassword){
    def dockerHome = tool name: 'docker-1', type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
    bat "${dockerHome}/bin/docker login -u $dockerUser -p $dockerPassword"
    bat "${dockerHome}/bin/docker tag $containerName:$tag $dockerUser/$containerName:$tag"
    bat "${dockerHome}/bin/docker push $dockerUser/$containerName:$tag"
    echo "Image push complete"
}

