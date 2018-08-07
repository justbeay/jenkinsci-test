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

// def adict = null
def setValue(key, value) {
    if(!this.adict) {
        this.adict = [:]
    }
    this.adict[key] = value
}
def getValue(key) {
    return this.adict[key]
}

return this