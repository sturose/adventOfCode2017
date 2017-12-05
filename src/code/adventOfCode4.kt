package code

import java.util.*

fun day4problem1(inputString: String): Any? {

    val lines = inputString.split("\n".toRegex())

    var validCount = 0;


    for (line in lines) {
        val words = line.split(" ".toRegex())
        if (words.size.toLong() == words.stream().distinct().count()) {
            validCount++
        }
    }

    return validCount
}

fun day4problem2(inputString: String): Any? {
    val lines = inputString.split("\n".toRegex())

    var validCount = 0


    for (line in lines) {
        var sortedWords = mutableListOf<String>()
        val words = line.split(" ".toRegex())
        for (word in words) {
            val toCharArray = word.toCharArray()
            toCharArray.sort()
            sortedWords.add(String(toCharArray))

        }
        if (sortedWords.size.toLong() == sortedWords.stream().distinct().count()) {
            validCount++
        }
    }

    return validCount
}
