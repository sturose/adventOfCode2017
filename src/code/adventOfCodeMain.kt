package code

import java.io.File


fun main(args: Array<String>) {
    val file = ClassLoader.getSystemResource("resources/input1.txt").file
    val inputString = File(file).readText().trim()

    println("Day 1: ")
    println(problem1(inputString))
    println(problem2(inputString))


    println("\nDay 2: ")
    val file2 = ClassLoader.getSystemResource("resources/input2.txt").file
    val inputString2 = File(file2).readText().trim()
    println(day2problem1(inputString2))
    println(day2problem2(inputString2))

    println("\nDay 3: ")
    println(day3problem1(368078))
    println(day3problem2(368078))

    println("\nDay 4: ")
    println(day3problem1(368078))
    println(day3problem2(368078))
}


