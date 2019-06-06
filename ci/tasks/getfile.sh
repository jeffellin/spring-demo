#!/bin/sh 
file="release-2cfd74.tgz"
bucket="releases"
resource="/${bucket}/${file}"
contentType="text/html"
dateValue="`date +'%a, %d %b %Y %H:%M:%S %z'`"
stringToSign="GET\n\n${contentType}\n${dateValue}\n${resource}"
s3Key='minio'
s3Secret='minio123'
signature=`/bin/echo -en "$stringToSign" | openssl sha1 -hmac ${s3Secret} -      binary | base64`

curl -v -H "Host:minio.ellin.net" \
        -H "Date:${dateValue}" \
        -H "Content-Type:${contentType}" \
        -H "Authorization: AWS ${s3Key}:${signature}" \
        https://${bucket}.s3.amazonaws.com/${file}