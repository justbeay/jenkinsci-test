#!groovy
package com.github.justbeay;

class Foo{
    def String serviceName
    def Integer buildNumber
    def String buildResult

    Foo(serviceName, buildNumber){
        this.serviceName = serviceName
        this.buildNumber = Integer.valueOf(buildNumber)
    }

    void setBuildResult(String buildResult){
        this.buildResult = buildResult
    }

    String getInfo(){
        return "{ serviceName: '${serviceName}', buildNumber: ${buildNumber}, buildResult: '${buildResult}' }"
    }

    void test(){
        echo "========= test start =========="
        sh "pwd"
        echo "job: ${env.JOB_NAME}, branch: ${params.TRIGGER_BRANCH}"
        echo "========= test end =========="
    }
}