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

// // def adict = null
// def setValue(key, value) {
//     if(!this.hasProperty("adict")) {
//         this.adict = [:]
//     }
//     this.adict[key] = value
// }
// def getValue(key) {
//     return this.adict[key]
// }
def var1 = 'init'
def setValue(value) {
    var1 = value
}
def getValue() {
    return this.var1
}

return this