#!groovy
package com.github.justbeay;

class Foo{
    def String serviceName
    def Integer buildNumber
    def String buildResult

    Foo(serviceName, buildNumber){
        this.serviceName = serviceName
        this.buildNumber = buildNumber.toInteger()
    }

    void setBuildResult(String buildResult){
        this.buildResult = buildResult
    }

    String getInfo(){
        return "\\{ serviceName: '${serviceName}', buildNumber: ${buildNumber}, buildResult: '${buildResult}' \\}"
    }
}