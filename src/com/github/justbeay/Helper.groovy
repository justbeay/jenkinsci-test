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

def var1 = 'init'
def setVar1(value) {
    var1 = value
}
def getVar1() {
    return var1
}

return this