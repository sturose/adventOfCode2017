package code


fun day13problem1(inputString: String): Any? {
    var lines = inputString.split("\n".toRegex())


    var depths = mutableListOf<Int>()
    var position = mutableListOf<Int>()
    var direction = mutableListOf<Boolean>()

    for (line in lines) {
        val split = line.split(":".toRegex())
        val index = split[0].toInt()
        while (depths.size < index) {
            depths.add(-1)
            position.add(0)
            direction.add(true)
        }
        val depth = split[1].trim().toInt()
        depths.add(depth - 1)
        position.add(0)
        direction.add(true)
    }


    var severity = 0
    for (index in 0..depths.size - 1) {
        if (depths[index] != -1) {
            if (position[index] == 0) {
                severity += (depths[index] + 1) * index
            }
        }

        for (incrIndex in 0..depths.size - 1) {
            if (depths[incrIndex] != -1) {
                if (direction[incrIndex]) {
                    position[incrIndex] += 1
                    if (position[incrIndex] == depths[incrIndex]) {
                        direction[incrIndex] = false
                    }
                } else {
                    position[incrIndex] -= 1
                    if (position[incrIndex] == 0) {
                        direction[incrIndex] = true
                    }
                }
            }
        }
    }

    return severity

}


fun day13problem2(inputString: String): Any? {

    var delay = 0
    while (caught(inputString, delay)) {
        delay += 1
    }

    return delay
}

private fun caught(inputString: String, delay: Int): Boolean {
    var lines = inputString.split("\n".toRegex())


    var depths = mutableListOf<Int>()
    var position = mutableListOf<Int>()
    var direction = mutableListOf<Boolean>()

    for (line in lines) {
        val split = line.split(":".toRegex())
        val index = split[0].toInt()
        while (depths.size < index) {
            depths.add(-1)
            position.add(0)
            direction.add(true)
        }
        val depth = split[1].trim().toInt()
        depths.add(depth - 1)
        position.add(0)
        direction.add(true)
    }

    if (delay != 0) {
        for (incrIndex in 0..depths.size - 1) {
            if (depths[incrIndex] != -1) {
                val offset = delay % (depths[incrIndex] * 2)
                if (offset != 0) {
                    if (offset <= depths[incrIndex]) {
                        position[incrIndex] = offset
                    } else {
                        position[incrIndex] = depths[incrIndex] - (offset - depths[incrIndex])
                    }
                    if(offset >= depths[incrIndex]){
                        direction[incrIndex] = false
                    }
                }
            }
        }
    }



    for (index in 0..depths.size - 1) {
        if (depths[index] != -1) {
            if (position[index] == 0) {
                return true
            }
        }

        for (incrIndex in 0..depths.size - 1) {
            if (depths[incrIndex] != -1) {
                if (direction[incrIndex]) {
                    position[incrIndex] += 1
                    if (position[incrIndex] == depths[incrIndex]) {
                        direction[incrIndex] = false
                    }
                } else {
                    position[incrIndex] -= 1
                    if (position[incrIndex] == 0) {
                        direction[incrIndex] = true
                    }
                }
            }
        }
    }

    return false
}