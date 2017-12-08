package code

import java.util.*

var highestEver = -999

fun day8problem1(inputString: String): Any? {

    val lines = inputString.split("\n".toRegex())

    var registers = hashMapOf<String, Int>()

    for (line in lines) {
        val words = line.split(" ".toRegex())
        val name1 = words[0]
        val name2 = words[4]
        if (!registers.containsKey(name1)) {
            registers.put(name1, 0)
        }
        if (!registers.containsKey(name2)) {
            registers.put(name2, 0)
        }

        processLine(registers, words)

    }

    var largest = -999
    for( entry in registers){
        if(entry.value > largest){
            largest = entry.value
        }
    }

    return largest
}

fun processLine(registers: HashMap<String, Int>, words: List<String>) {
    val action = words[1]
    val value = words[2]
    val comparison = words[5]
    val comparisonName = registers[words[4]]

    if (comparisonName != null) {

        when (comparison) {
            ">" -> {
                if (comparisonName > words[6].toInt()) {
                    doAction(action, value, registers, words[0])
                }
            }
            ">=" -> {
                if (comparisonName >= words[6].toInt()) {
                    doAction(action, value, registers, words[0])
                }
            }
            "<" -> {
                if (comparisonName < words[6].toInt()) {
                    doAction(action, value, registers, words[0])
                }
            }
            "<=" -> {
                if (comparisonName <= words[6].toInt()) {
                    doAction(action, value, registers, words[0])
                }
            }
            "==" -> {
                if (comparisonName == words[6].toInt()) {
                    doAction(action, value, registers, words[0])
                }
            }
            "!=" -> {
                if (comparisonName != words[6].toInt()) {
                    doAction(action, value, registers, words[0])
                }
            }
        }
    }

}

fun doAction(action: String, value: String, registers: HashMap<String, Int>, key: String) {
    if ("inc".equals(action)) {
        var get = registers.get(key)
        if (get != null) {
            registers.put(key, get.plus(value.toInt()))
        }
    }
    if ("dec".equals(action)) {
        var get = registers.get(key)
        if (get != null) {
            registers.put(key, get.minus(value.toInt()))
        }
    }
}

fun day8problem2(inputString: String): Any? {
    val lines = inputString.split("\n".toRegex())

    var registers = hashMapOf<String, Int>()

    for (line in lines) {
        val words = line.split(" ".toRegex())
        val name1 = words[0]
        val name2 = words[4]
        var value = 0
        if (!registers.containsKey(name1)) {
            registers.put(name1, 0)
        }
        if (!registers.containsKey(name2)) {
            registers.put(name2, 0)
        }

        processLine(registers, words)

        if(registers.get(name1) != null) {
            value = registers.get(name1)!!
            if (value > highestEver) {
                highestEver = value
            }
        }
    }

    var largest = -999
    for( entry in registers){
        if(entry.value > largest){
            largest = entry.value
        }
    }

    return highestEver
}