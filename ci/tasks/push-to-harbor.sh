#!/bin/bash

echo "hello world"

#VERSION=$(cat release/version)
ls
set -ex
#ls release
#cd release
#tar xvf release-${VERSION}.tgz

helm init --client-only
helm repo add harbor https://harbor.ellin.net/chartrepo/library  --ca-file source-code/kubernetes/harbor.pem --username jeff --password 'Pivotal!23'
helm push source-code/kubernetes/spring-demo harbor --ca-file source-code/kubernetes/harbor.pem  --username jeff --password 'Pivotal!23'

# pks login -a ${PKS_ENDPOINT} -u ${PKS_USER} -p ${PKS_PASSWORD} -k
# pks get-credentials ${PKS_CLUSTER}
#kubectl get pods
#template=`cat "spring-demo-pod.yml" | sed "s/{VERSION}/$VERSION/g"`
# apply the yml with the substituted value
#echo "$template" > ../pks-build/spring-demo-modified.yml