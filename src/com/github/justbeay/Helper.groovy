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

def adict
def setValue(key, value) {
    if(!adict) {
        adict = [:]
    }
    adict[key] = value
}
def getValue(key) {
    return adict[key]
}

return this