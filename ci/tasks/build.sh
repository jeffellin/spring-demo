#!/bin/bash

set -eux

export ROOT_FOLDER="$( pwd )"

pushd source-code
    ls
	mvn clean package 
popd

cp source-code/docker/Dockerfile source-code/target
ls source-code/target