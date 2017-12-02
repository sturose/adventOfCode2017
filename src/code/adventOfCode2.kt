package code

fun day2problem1(inputString: String): Any? {
    var lowest: Long
    var highest: Long
    var total: Long = 0

    val inputString = inputString.replace('\t', ' ')

    val lines = inputString.split("\n")

    for (line in lines) {
        val numbersString = line.split(' ')

        var value = numbersString[0].toLong()
        lowest = value
        highest = value

        for (numString in numbersString) {
            var value = numString.toLong()
            if (value < lowest) {
                lowest = value
            }
            if (value > highest) {
                highest = value
            }
        }


        var diff = highest - lowest;
        total += diff
    }

    return total
}

fun day2problem2(inputString: String): Any? {
    var lowest: Long
    var highest: Long
    var total: Long = 0

    val inputString = inputString.replace('\t', ' ')

    val lines = inputString.split("\n")

    for (line in lines) {
        val numbersString = line.split(' ')

        val zeroLong: Long = 0

        for (numString in numbersString) {
            var value = numString.toLong()
            for (numString2 in numbersString) {
                var value2 = numString2.toLong()
                if(value == value2){
                    continue
                }
                if (value2 % value == zeroLong) {
                    total += (value2 / value)
                    break
                }
            }
        }

    }

    return total
}
