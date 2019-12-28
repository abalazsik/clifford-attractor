FROM tomcat:9.0-jdk13-openjdk-oracle
COPY target/clifford.war /usr/local/tomcat/webapps
