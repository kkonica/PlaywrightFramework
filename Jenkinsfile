pipeline
{
    agent any
    tools{
        	maven 'maven'
            }

    stages
    {
        stage('Build')
        {
           steps{
                           echo("Building!!!!!!!!!!!!!!!!!!!!")
                       }
        }



        stage("Deploy to QA"){
            steps{
                echo("deploy to qa!!!!!!!!!!!!!!!!!!!")
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
