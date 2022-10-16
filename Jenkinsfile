pipeline
{
    agent any
    stages
    {
        stage('Build')
        {
            steps
                        {
                             git 'https://github.com/jglick/simple-maven-project-with-tests.git'
                             sh "mvn -Dmaven.test.failure.ignore=true clean package"
                        }
                        post
                        {
                            success
                            {
                                junit '**/target/surefire-reports/TEST-*.xml'
                                archiveArtifacts 'target/*.jar'
                            }
                        }
        }



        stage("Deploy to QA"){
            steps{
                echo("deploy to qa")
            }
        }

        stage('Regression Automation Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git 'https://github.com/kkonica/PlaywrightFramework'
                    sh "mvn clean test"

                }
            }
        }

    }
}
