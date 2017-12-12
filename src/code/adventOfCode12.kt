package code


fun day12problem1(inputString: String): Any? {
    var alreadyCounted = mutableListOf<Int>()
    var lines = inputString.split("\n".toRegex())
    return getCount(lines, alreadyCounted,  0)
}

fun getCount(lines: List<String>, alreadyCounted: MutableList<Int>, index: Int): Int {
    if (alreadyCounted.contains(index)) {
        return 0
    } else {
        alreadyCounted.add(index)
    }

    val programIds = lines[index].split(" ".toRegex())

    var retVal = 1
    for (i in 2..programIds.size-1) {
        retVal += getCount(lines, alreadyCounted, programIds[i].substringBefore(",").toInt())
    }
    return retVal
}

fun day12problem2(inputString: String): Any? {

    var alreadyCounted = mutableListOf<Int>()

    var totalGroups = 0
    var lines = inputString.split("\n".toRegex())
    for(i in 0..lines.size-1) {
        if(getCount(lines, alreadyCounted, i) != 0){
            totalGroups += 1
        }
    }
    return totalGroups
}