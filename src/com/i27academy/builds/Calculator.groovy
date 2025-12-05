// i will be defining a package.
package com.i27academy.builds

// Defining a class
class Calculator {

    // define a variable to hold the jenkins content
    // in Jenkinsfile, we run steps like echo, sh, checkout,
    def jenkins

    // Constructor
    Calculator(jenkins) {
        this.jenkins = jenkins
    }

    // Create a method to add numbers
    def add(firstNumber, secondNumber) {
        // logic to add 2 numbers
        return firstNumber + secondNumber
    }
}