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
                    sh "mvn test"

                }
            }
        }

            stage('Publish Extent Report'){
                        steps{
                                 publishHTML([allowMissing: false,
                                              alwaysLinkToLastBuild: false,
                                              keepAll: true,
                                              reportDir: 'test-output/htmlReports/',
                                              reportFiles: 'automation-report.html',
                                              reportName: 'HTML Extent Report',
                                              reportTitles: ''])
                        }
            }
    }
}
