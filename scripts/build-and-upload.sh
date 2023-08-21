#!/bin/bash
set -e
ERROR_RED='\033[0;31m'

if [ -n "$1" ]; then
  echo "Setting backend host to: $1"
else
  echo "${ERROR_RED}"
  echo "No backend host arg was provided"
  echo "Usage example: sh scripts/cicd/build-and-upload.sh "http://localhost:9023" "Product-Name""
  exit 1
fi
if [ -n "$2" ]; then
  echo "Product name: $2"
else
  echo "${ERROR_RED}"
  echo "No product name arg was provided"
  echo "Usage example: sh scripts/cicd/build-and-upload.sh "http://localhost:9023" "Product-Name""
  exit 1
fi

# change backend host url in properties
TOOLBOX_SERVER=$1

# build with new properties
mvn clean package

PROJECT_VERSION=$(mvn org.apache.maven.plugins:maven-help-plugin:3.2.0:evaluate -Dexpression=project.version -q -DforceStdout)
PROJECT_NAME=$2
echo "Uploading product: $PROJECT_VERSION/$PROJECT_NAME"

UPLOAD_URL="$TOOLBOX_SERVER/products/upload/$PROJECT_NAME/$PROJECT_VERSION"
echo "Uploading to: $UPLOAD_URL"
CURL_OUT= $(curl -X "POST" \
  "$UPLOAD_URL" \
  -H "accept: */*" \
  -H "Content-Type: multipart/form-data" \
  -F "file=@target/demo-app.exe;type=application/x-msdownload")
echo $CURL_OUT
