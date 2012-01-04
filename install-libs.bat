@echo off
CLS

ECHO Installing TIBCO dependencies
PAUSE

mvn -e install:install-file -Dfile=./lib/jms.jar -DgroupId=com.cvc.techarch -DartifactId=jms -Dversion=1.0 -Dpackaging=jar && mvn -e install:install-file -Dfile=./lib/tibjms.jar -DgroupId=com.cvc.techarch -DartifactId=tibjms -Dversion=1.0 -Dpackaging=jar  && ECHO - complete! && PAUSE