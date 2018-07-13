#!/usr/bin/env groovy
@Library('test-shared-library')
import com.github.justbeay.Foo

node {
    echo "======== TRIGGER_BRANCH:${params.TRIGGER_BRANCH}, TRIGGER_Boolean:${params.TRIGGER_Boolean}, TRIGGER_Choice:${params.TRIGGER_Choice} ======="
    stage 'compile'
    dir('src'){
        checkout([
            $class: 'GitSCM',
            branches: [[name: params.TRIGGER_BRANCH]],
            doGenerateSubmoduleConfigurations: false,
            extensions: [[$class: 'CleanBeforeCheckout']],
            submoduleCfg: [],
            userRemoteConfigs: [[
                url: 'git@github.com:justbeay/jenkinsci-test.git'
            ]]
        ])
        sh "mvn clean install"
    }
    stage 'deploy'
    currentBuild.result = 'SUCCESS'
    access_steps_test()
    library_class_test()
    // update_commit_status('justbeay', 'jenkinsci-test', params.PULL_REQUEST_NUMBER, 'pending')
    echo "======== finish ${env.JOB_NAME}, with build number:${env.BUILD_NUMBER} ========"
    // update_commit_status('justbeay', 'jenkinsci-test', params.PULL_REQUEST_NUMBER, 'success')
}

def update_commit_status(owner, repository, pullNumber, state) {
    if(pullNumber){
        withCredentials([usernamePassword(credentialsId: 'GITHUB_ACCESS_TOKEN', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]){
            sh "pwd"
            sh "./src/script/git_commit_status.py --user ${USERNAME} --token ${PASSWORD}" +
                " --owner ${owner}" +
                " --repository ${repository}" +
                " --pull-number ${pullNumber}" +
                " --state ${state}" +
                // " --target-url '${BUILD_URL}'"
                " --description 'jenkins build job:${BUILD_NUMBER} ${state}'"
                " --context 'continuous-integration/jenkins'"
        }
    }
}

def access_steps_test(){
    def helper = new com.github.justbeay.Helper()
    helper.info("access_steps_test...")
}

def library_class_test(){
    def foo = new Foo(env.JOB_NAME, env.BUILD_NUMBER)
    foo.setBuildResult(currentBuild.currentResult)
    echo foo.getInfo()
    foo.test()
}