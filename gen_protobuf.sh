#!/bin/bash

PROTO_DIR="./proto"
FILES=$(find $PROTO_DIR -name '*.proto')
TARGET="./src/java"

mkdir -p $TARGET

protoc --java_out=$TARGET \
       -I/usr/local/include \
       -I$GOPATH/src/github.com/grpc-ecosystem/grpc-gateway/third_party/googleapis \
       -Itarget/proto \
       -I./proto \
       -I. \
       $FILES
