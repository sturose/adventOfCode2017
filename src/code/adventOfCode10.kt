package code

fun day10problem1(inputString: String): Any? {

    var normalizedLine = inputString.replace('\t', ' ')

    var numberStrings = normalizedLine.split(",".toRegex())

    val input = ArrayList<Int>()
    val numbers = ArrayList<Int>()

    numberStrings.mapTo(input) { it.toInt() }
    numbers += 0..255

    var index = 0
    var skipSize = 0
    var arraySize = numbers.size

    for (range in input) {
        val startIndex = index
        val endIndex = (index + range - 1) % arraySize
        for (i in 0..(range / 2 - 1)) {
            val swapValue = numbers[(startIndex + i) % arraySize]
            numbers[(startIndex + i) % arraySize] = numbers[(arraySize + endIndex - i) % arraySize]
            numbers[(arraySize + endIndex - i) % arraySize] = swapValue
        }
        index += range
        index += skipSize
        index %= arraySize
        skipSize += 1
    }

    return numbers[0] * numbers[1]
}

fun day10problem2(inputString: String): Any? {
    val numbers = ArrayList<Int>()
    var byteArray = inputString.toByteArray()
    numbers += 0..255

    byteArray = byteArray.plus(17)
    byteArray = byteArray.plus(31)
    byteArray = byteArray.plus(73)
    byteArray = byteArray.plus(47)
    byteArray = byteArray.plus(23)

    var index = 0
    var skipSize = 0
    var arraySize = numbers.size

    for (round in 0..63) {
        for (range in byteArray) {
            val startIndex = index
            val endIndex = (index + range - 1) % arraySize
            for (i in 0..(range / 2 - 1)) {
                val swapValue = numbers[(startIndex + i) % arraySize]
                numbers[(startIndex + i) % arraySize] = numbers[(arraySize + endIndex - i) % arraySize]
                numbers[(arraySize + endIndex - i) % arraySize] = swapValue
            }
            index += range
            index += skipSize
            index %= arraySize
            skipSize += 1
        }
    }

    val denseHash = calculateDenseHash(numbers)

    var outputString = ""
    for(hashValue in denseHash){
        outputString = outputString.plus(String.format("%02X", hashValue).toLowerCase())
    }

    return outputString
}

fun calculateDenseHash(numbers: ArrayList<Int>): ArrayList<Int> {
    val denseHash = ArrayList<Int>()

    for(blockIndex in 0..(numbers.size/16 - 1)){
        var value =  numbers[blockIndex*16]
        for(index in 1..15){
            value = numbers[blockIndex*16 + index].xor(value)
        }
        denseHash.add(value)
    }
    return denseHash
}
