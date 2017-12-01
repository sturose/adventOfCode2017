package code

import java.io.File

fun main(args: Array<String>) {
    val file = ClassLoader.getSystemResource("resources/input1.txt").file
    val inputString = File(file).readText().trim()
    println(problem1(inputString))
    println(problem2(inputString))
}

fun problem1(inputString: String): Any? {
    var prevChar = '0'  // zero is a sane default
    var currentChar = '0'
    var total = 0

    for(char in inputString){
        currentChar = char
        if(prevChar == currentChar){
            total += Character.getNumericValue(prevChar)
        }
        prevChar = currentChar
    }

    if(currentChar == inputString.get(0)){
        total += Character.getNumericValue(currentChar)
    }
    return total
}


fun problem2(inputString: String): Any? {
    var total = 0
    inputString.length

    for(i in inputString.indices){
        var currentChar = inputString[i]
        var halfwayChar = inputString[(inputString.length/2 + i) % inputString.length]
        if(halfwayChar == currentChar){
            total += Character.getNumericValue(currentChar)
        }
    }

    return total
}

