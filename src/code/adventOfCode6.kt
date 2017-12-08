package code

fun day6problem1(inputString: String): Any? {

    var normalizedLine = inputString.replace('\t', ' ')
    var numbers = normalizedLine.split(" ".toRegex())
    var values = ArrayList<Int>()
    var jumps = 0

    for (number in numbers) {
        values.add(number.toInt())
    }
    val size = values.size

    var stack = mutableListOf<String>()


    var stateString = values.toString()
    while (!stack.contains(stateString)) {
        stack.add(stateString)
        val largestIndex = largestIndex(values)
        jumps += 1
        var valueToAdd = values[largestIndex]
        values[largestIndex] = 0

        var offset = 1
        while (valueToAdd > 0) {
            values[(largestIndex + offset) % size] += 1
            offset += 1
            valueToAdd -= 1
        }

        stateString = values.toString()

    }


    return jumps
}

private fun largestIndex(values: ArrayList<Int>): Int {
    var maxValue = values[0]
    var count = 0
    var returnIndex = 0
    for (value in values) {
        if (value > maxValue) {
            maxValue = value
            returnIndex = count
        }
        count += 1
    }
    return returnIndex
}

fun day6problem2(inputString: String): Any? {


    var normalizedLine = inputString.replace('\t', ' ')
    var numbers = normalizedLine.split(" ".toRegex())
    var values = ArrayList<Int>()
    var jumps = 0

    for (number in numbers) {
        values.add(number.toInt())
    }
    val size = values.size

    var stack = mutableListOf<String>()


    var stateString = values.toString()
    while (!stack.contains(stateString)) {
        stack.add(stateString)
        val largestIndex = largestIndex(values)
        jumps += 1
        var valueToAdd = values[largestIndex]
        values[largestIndex] = 0

        var offset = 1
        while (valueToAdd > 0) {
            values[(largestIndex + offset) % size] += 1
            offset += 1
            valueToAdd -= 1
        }

        stateString = values.toString()
    }


    return jumps - stack.indexOf(stateString)
}