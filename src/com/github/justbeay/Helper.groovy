#!groovy
package com.github.justbeay;

def test() {
    return "hello, world..."
}

def info(message) {
    sh "echo current dir is: `pwd`"
    echo "INFO: ${message}"
    echo test()
}

def adict = {}
def setName(value) {
    adict['name'] = value
}
def getName() {
    return adict['name']
}

return this