#!/bin/bash

set -eux

export ROOT_FOLDER="$( pwd )"

pushd source
    ls
	mvn clean package 
popd