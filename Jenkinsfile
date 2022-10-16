pipeline
{
    agent any
    stages
    {
        stage('Build')
        {
            steps{
                            echo("Build")
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


        stage('Publish Extent Report'){
            steps{
                     publishHTML([allowMissing: false,
                                  alwaysLinkToLastBuild: false,
                                  keepAll: true,
                                  reportDir: 'htmlReports',
                                  reportFiles: 'automation-report.html',
                                  reportName: 'HTML Extent Report',
                                  reportTitles: ''])
            }
        }




    }
}
