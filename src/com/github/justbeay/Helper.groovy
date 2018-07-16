#!groovy
package com.github.justbeay;

def aaa = "hello"

def info(message) {
    sh "echo current dir is: `pwd`"
    echo "INFO: ${message}"
}

def testAaa() {
    echo "== aaa: ${aaa} =="
}

return this