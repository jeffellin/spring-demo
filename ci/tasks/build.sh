#!/bin/bash

set -eux

export ROOT_FOLDER="$( pwd )"

pushd source-code
    ls
	mvn clean package 
popd