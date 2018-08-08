package com.github.justbeay

class Utilities implements Serializable {
    def steps
    Utilities(steps) {this.steps = steps}
    def mvn(args) {
        steps.sh "mvn -o ${args}"
    }
}