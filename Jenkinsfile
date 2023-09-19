pipeline{
    agent any
    tools{
        maven 'MAVEN_3_8_6'
        jdk 'JDK_8'
    }
    stages{
        stage('Compilar') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage ('Javadoc') {
            steps {
                bat 'mvn javadoc:javadoc'    
                javadoc javadocDir: './target/site/apidocs', keepAll: false
            }
        }
        
        stage("Checkstyle") {
            steps{
                 bat 'mvn --batch-mode -V -U -e checkstyle:checkstyle pmd:pmd pmd:cpd findbugs:findbugs com.github.spotbugs:spotbugs-maven-plugin:3.1.7:spotbugs'
            }
            post {
                always {
                    recordIssues enabledForFailure: true, tools: [mavenConsole(), java(), javaDoc()]
                    recordIssues enabledForFailure: true, tool: checkStyle()
                    recordIssues enabledForFailure: true, tool: findBugs()
                    recordIssues enabledForFailure: true, tool: spotBugs()
                    recordIssues enabledForFailure: true, tool: cpd(pattern: '**/target/cpd.xml')
                    recordIssues enabledForFailure: true, tool: pmdParser(pattern: '**/target/pmd.xml')
                }
            }
        }        

        stage('Cobertura'){
            steps{
                bat 'mvn cobertura:cobertura -Dcobertura.report.format=xml'
                step([$class: 'CoberturaPublisher', autoUpdateHealth: false, autoUpdateStability: false, coberturaReportFile: '**/coverage.xml', failUnhealthy: false, failUnstable: false, maxNumberOfBuilds: 0, onlyStable: false, sourceEncoding: 'ASCII', zoomCoverageChart: false])
            }             
        }
        
        stage('Test y Jacoco') {
            steps {
                junit '**/*.xml'
                jacoco()
            }
        }
    }
    post {
        always {
            cleanWs()
            dir("${env.WORKSPACE}@tmp") {
                deleteDir()
            }
            dir("${env.WORKSPACE}@script") {
                deleteDir()
            } 
        }
    }    
}