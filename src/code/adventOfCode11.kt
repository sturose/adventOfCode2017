package code

import kotlin.math.abs

fun day11problem1(inputString: String): Any? {

    var normalizedLine = inputString.replace('\t', ' ')

    var directions = normalizedLine.split(",".toRegex())

    var vertCount = 0
    var horCount = 0

    for (direction in directions) {
        val addVal = 3 - direction.length
        for(i in 0..direction.length - 1) {
            if (direction.get(i).equals('n')) {
                vertCount += addVal
            }
            if (direction.get(i).equals('s')) {
                vertCount -= addVal
            }
            if (direction.get(i).equals('e')) {
                horCount += addVal
            }
            if (direction.get(i).equals('w')) {
                horCount -= addVal
            }
        }
    }
    if(abs(vertCount) > abs(horCount)){
        return (abs(vertCount) - abs(horCount)) /2 + abs(horCount)
    }

    return abs(horCount)
}

fun day11problem2(inputString: String): Any? {

    var normalizedLine = inputString.replace('\t', ' ')

    var directions = normalizedLine.split(",".toRegex())

    var vertCount = 0
    var horCount = 0
    var max = 0

    for (direction in directions) {
        val addVal = 3 - direction.length
        for(i in 0..direction.length - 1) {
            if (direction.get(i).equals('n')) {
                vertCount += addVal
            }
            if (direction.get(i).equals('s')) {
                vertCount -= addVal
            }
            if (direction.get(i).equals('e')) {
                horCount += addVal
            }
            if (direction.get(i).equals('w')) {
                horCount -= addVal
            }
        }
        if(abs(vertCount) > max){
            if(max < (abs(vertCount) - abs(horCount)) /2 + abs(horCount)) {
                max = (abs(vertCount) - abs(horCount)) /2 + abs(horCount)
            }
        }
        if(abs(horCount) > max){
            max = abs(horCount)
        }
    }

    return max
}