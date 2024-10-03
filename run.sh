#!/bin/bash

if [ $# -lt 1 ]; then
    echo "./run.sh <file> *args"
    exit 1
fi

file=$1
classpath=$(echo $file | sed s'/.java//' | sed s'/\//./')

javac $file
if [ $? -ne 0 ]; then
    echo "Compilation error"
    exit 1
fi

java $classpath "${@:2}"