#!/bin/bash
set -e

PROJECT_VERSION=$(mvn org.apache.maven.plugins:maven-help-plugin:3.2.0:evaluate -Dexpression=project.version -q -DforceStdout)
sed -i "s|APP_VERSION =.*|APP_VERSION = \"$PROJECT_VERSION\";|" src/main/java/com/zuken/zicdemoapp/Application.java
