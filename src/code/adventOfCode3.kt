package code


fun day3problem1(input: Int): Any? {
    var lowestOnRing: Int = 2
    var numPerSide: Int = 1
    var highestOnRing = 1

    while (highestOnRing < input) {
        lowestOnRing = highestOnRing
        numPerSide += 2
        highestOnRing += numPerSide * 4 - 4
    }

    val corner1 = highestOnRing
    val corner2 = highestOnRing - ((highestOnRing - lowestOnRing) / 4)
    val corner3 = highestOnRing - (2 * (highestOnRing - lowestOnRing) / 4)
    val corner4 = highestOnRing - (3 * (highestOnRing - lowestOnRing) / 4)
    val corner5 = lowestOnRing - 1

    var stepsAwayFromCorner = numPerSide
    if (Math.abs(input - corner1) < stepsAwayFromCorner) {
        stepsAwayFromCorner = Math.abs(input - corner1)
    }
    if (Math.abs(input - corner2) < stepsAwayFromCorner) {
        stepsAwayFromCorner = Math.abs(input - corner2)
    }
    if (Math.abs(input - corner3) < stepsAwayFromCorner) {
        stepsAwayFromCorner = Math.abs(input - corner3)
    }
    if (Math.abs(input - corner4) < stepsAwayFromCorner) {
        stepsAwayFromCorner = Math.abs(input - corner4)
    }
    if (Math.abs(input - corner5) < stepsAwayFromCorner) {
        stepsAwayFromCorner = Math.abs(input - corner5)
    }

    return (numPerSide - 1) - stepsAwayFromCorner

}

enum class direction {
    left,
    right,
    up,
    down
}

fun day3problem2(input: Int): Any? {
    var matrix = arrayListOf<IntArray>()

    val size = 100
    val mid = size / 2
    for (i in 0 until size) {
        var row = IntArray(100)
        for (k in 0 until size) {
            row[k] = 0
        }
        matrix.add(i, row)
    }

    matrix[mid][mid] = 1

    var direction = direction.right
    var index1 = mid
    var index2 = mid

    while (matrix[index1][index2] < input) {

        when (direction) {
            code.direction.right -> index1++
            code.direction.left  -> index1--
            code.direction.up    -> index2++
            code.direction.down  -> index2--
        }

        val calculatedValue = addSurrounding(matrix, index1, index2)
        matrix[index1][index2] = calculatedValue

        direction = directionChange(direction, matrix, index1, index2)
    }

    return matrix[index1][index2]
}

fun directionChange(direction: direction, matrix: ArrayList<IntArray>, index1: Int, index2: Int): direction {
    when (direction) {
        code.direction.right -> {
            if (matrix[index1][index2 + 1] == 0) {
                return code.direction.up
            }
        }
        code.direction.left  -> {
            if (matrix[index1][index2 - 1] == 0) {
                return code.direction.down
            }
        }
        code.direction.up    -> {
            if (matrix[index1 - 1][index2] == 0) {
                return code.direction.left
            }
        }
        code.direction.down  -> {
            if (matrix[index1 + 1][index2] == 0) {
                return code.direction.right
            }
        }
    }
    return direction
}

fun addSurrounding(matrix: ArrayList<IntArray>, index1: Int, index2: Int): Int {

    return matrix[index1][index2 + 1] + matrix[index1 + 1][index2 + 1] +
            matrix[index1 + 1][index2] + matrix[index1 + 1][index2 - 1] +
            matrix[index1][index2 - 1] + matrix[index1 - 1][index2 - 1] +
            matrix[index1 - 1][index2] + matrix[index1 - 1][index2 + 1]
}
