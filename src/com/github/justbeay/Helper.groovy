#!groovy
package com.github.justbeay;

Helper() {
    adict = [:]
}

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
    // if(!binding.hasVariable("adict")) {
    //     echo "========== init..."
    //     adict = [:]
    // }
    adict[key] = value
}
def getValue(key) {
    return adict[key]
}
// def var1 = 'init'
// def setValue(value) {
//     var1 = value
// }
// def getValue() {
//     return var1
// }

return this