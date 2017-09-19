mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=true sonar:sonar
mvn sonar-break:sonar-break
