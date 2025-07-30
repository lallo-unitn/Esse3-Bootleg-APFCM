FROM quay.io/wildfly/wildfly:30.0.0.Final-jdk17

RUN /opt/jboss/wildfly/bin/add-user.sh admin Admin#007 --silent

# COPY ./postgresql/ /opt/jboss/wildfly/modules/org/postgresql

# ADD ./standalone/standalone.xml /opt/jboss/wildfly/standalone/configuration/standalone.xml

COPY target/adv_prog_project_war.war  ${JBOSS_HOME}/standalone/deployments/
RUN  touch ${JBOSS_HOME}/standalone/deployments/adv_prog_project_war.war.dodeploy

