node {

		stage ('Build App')
		{
			echo 'Running Build App'
			checkout scm
			
			bat 'mvn clean package'
		}
				
	}