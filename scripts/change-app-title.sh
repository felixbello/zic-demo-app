#!/bin/bash
set -e

NEW_TITLE=$1
sed -i "s|APP_TITLE =.*|APP_TITLE = \"$NEW_TITLE\";|" src/main/java/com/zuken/zicdemoapp/Application.java
