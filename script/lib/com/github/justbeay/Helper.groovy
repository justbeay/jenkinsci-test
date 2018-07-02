#!groovy
package com.github.justbeay;

def info(message) {
    sh "echo current dir is: `pwd`"
    echo "INFO: ${message}"
}

return this