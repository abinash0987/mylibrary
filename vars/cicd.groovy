def gitDownload(repo)
{
   git "https://github.com/abinash0987/${repo}"
}

def gitBuild()
{
   sh 'mvn package'
}

def gitDeploy(jobname,ip,appname)
{
    sh "scp /var/lib/jenkins/workspace/${jobname}/webapp/target/webapp.war   ubuntu@${ip}:/var/lib/tomcat10/webapps/${appname}.war"
}

def runSelenium(jobname)
{
sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}
