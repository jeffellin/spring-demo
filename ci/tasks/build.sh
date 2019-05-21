#!/bin/bash

set -eux
export ROOT_FOLDER="$( pwd )"
source ${SCRIPT_DIR}/mvn-tools.sh
M2_HOME="${ROOT_FOLDER}/.m2"
M2_CACHE="${ROOT_FOLDER}/maven"



generate_settings
ls

pushd source-code
    ls
	mvn clean package -DskipTests
popd

mkdir packed-release/target
cp source-code/docker/Dockerfile packed-release/target/
cp source-code/target/web-demo-0.0.1-SNAPSHOT.jar packed-release/target/
tar zcvf packed-release/release-0.0.1.tgz -C packed-release/target .
ls packed-release