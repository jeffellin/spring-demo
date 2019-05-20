#!/bin/bash

set -eux

export ROOT_FOLDER="$( pwd )"
ls

pushd source-code
    ls
	mvn clean package 
popd

mkdir packed-release/target
cp source-code/docker/Dockerfile packed-release/target/
cp source-code/target/web-demo-0.0.1-SNAPSHOT.jar packed-release/target/
zip release-0.0.1.zip target/*