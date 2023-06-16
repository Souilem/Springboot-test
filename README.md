# Springboot-test

JAVA 17

mvn clean install

mvn install

mvn test

mvn verify

mvn site

--------------------------------------------------------------------------------------------------------------------
# Spring boot starter test

	       <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

--------------------------------------------------------------------------------------------------------------------
# Maven surfire report. /target directory

			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-plugin</artifactId>
				<configuration>
					<reportsDirectory>${project.build.directory}/surefireProduction-reports</reportsDirectory>
					<reportFormat>html</reportFormat>
					<trimStackTrace>false</trimStackTrace>
					<profiles>
						<profile>asciidoctor</profile>
					</profiles>
				</configuration>
			</plugin>
--------------------------------------------------------------------------------------------------------------------
# Jacoco report. /target directory

 			<plugin>
				<groupId>org.jacoco</groupId>
				<artifactId>jacoco-maven-plugin</artifactId>
				<version>0.8.7</version>
				<executions>
					<execution>
						<goals>
							<goal>prepare-agent</goal>
						</goals>
					</execution>
					<execution>
						<id>report</id>
						<phase>test</phase>
						<goals>
							<goal>report</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
--------------------------------------------------------------------------------------------------------------------
# Actuator

Actuator is a powerful feature that provides several production-ready tools and endpoints to monitor and manage your application. It enables you to gather useful information about your application's health, metrics, configuration, and more.

here are these endpoints, you can configure whatever you like to set up your application logs, metrics, beans...

        "self": {
            "href": "http://localhost:9090/actuator",
            "templated": false
        },
        "beans": {
            "href": "http://localhost:9090/actuator/beans",
            "templated": false
        },
        "caches-cache": {
            "href": "http://localhost:9090/actuator/caches/{cache}",
            "templated": true
        },
        "caches": {
            "href": "http://localhost:9090/actuator/caches",
            "templated": false
        },
        "health-path": {
            "href": "http://localhost:9090/actuator/health/{*path}",
            "templated": true
        },
        "health": {
            "href": "http://localhost:9090/actuator/health",
            "templated": false
        },
        "info": {
            "href": "http://localhost:9090/actuator/info",
            "templated": false
        },
        "conditions": {
            "href": "http://localhost:9090/actuator/conditions",
            "templated": false
        },
        "configprops-prefix": {
            "href": "http://localhost:9090/actuator/configprops/{prefix}",
            "templated": true
        },
        "configprops": {
            "href": "http://localhost:9090/actuator/configprops",
            "templated": false
        },
        "env": {
            "href": "http://localhost:9090/actuator/env",
            "templated": false
        },
        "env-toMatch": {
            "href": "http://localhost:9090/actuator/env/{toMatch}",
            "templated": true
        },
        "loggers": {
            "href": "http://localhost:9090/actuator/loggers",
            "templated": false
        },
        "loggers-name": {
            "href": "http://localhost:9090/actuator/loggers/{name}",
            "templated": true
        },
        "heapdump": {
            "href": "http://localhost:9090/actuator/heapdump",
            "templated": false
        },
        "threaddump": {
            "href": "http://localhost:9090/actuator/threaddump",
            "templated": false
        },
        "metrics-requiredMetricName": {
            "href": "http://localhost:9090/actuator/metrics/{requiredMetricName}",
            "templated": true
        },
        "metrics": {
            "href": "http://localhost:9090/actuator/metrics",
            "templated": false
        },
        "scheduledtasks": {
            "href": "http://localhost:9090/actuator/scheduledtasks",
            "templated": false
        },
        "mappings": {
            "href": "http://localhost:9090/actuator/mappings",
            "templated": false
        }

for example, for this post method:  http://localhost:9090/actuator/loggers 
you can change the log levels and tell spring do not display debug level logs in production. 

--------------------------------------------------------------------------------------------------------------------

# Spring logging

https://www.baeldung.com/spring-boot-logging#:~:text=In%20the%20case%20of%20logging,Spring%20Boot%202.x).
