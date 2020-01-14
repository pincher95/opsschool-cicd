stage("test") {
    slackColor = "good"
    end = "success"
    try {
      sh "ecko"
    } catch (Exception e) {
      echo "ERROR: " + e
      slackColor = "danger"
      end = "failure"
      currentBuild.result = "FAILURE"
    } finally {
        slackSend color: slackColor, message: "Build finished with ${end}: ${env.JOB_NAME} #${env.BUILD_NUMBER}"
    }
}
