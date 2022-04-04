node {

		stage ('Build App')
		{
			echo 'Running Build App'
			checkout scm
			
			bat 'mvn clean package'
		}
				
	

stage ('Run unit test')
	{
		echo 'Running Unit Tests'
	
		bat 'mvn clean test -Dtest=HolaControllerTest'
					
		step([$class: 'JUnitResultArchiver', testResults: "**/surefire-reports/*.xml"]) 
			
	}

}