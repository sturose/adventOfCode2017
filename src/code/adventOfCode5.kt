package code

fun day5problem1(inputString: String): Any? {

    val lines = inputString.split("\n".toRegex())

    var values = ArrayList<Int>()
    for(line in lines){
        values.add(line.toInt())
    }
    val end = values.size
    var index = 0
    var prevIndex = 0
    var jumps = 0

    while(index < end){
        index += values[index]
        values[prevIndex] += 1
        prevIndex = index
        jumps += 1

    }

    return jumps
}

fun day5problem2(inputString: String): Any? {
    val lines = inputString.split("\n".toRegex())

    var values = ArrayList<Int>()
    for(line in lines){
        values.add(line.toInt())
    }
    val end = values.size
    var index = 0
    var prevIndex = 0
    var jumps = 0

    while(index < end){
        index += values[index]
        if(values[prevIndex] >= 3){
            values[prevIndex] -= 1
        } else {
            values[prevIndex] += 1
        }
        prevIndex = index
        jumps += 1

    }

    return jumps
}