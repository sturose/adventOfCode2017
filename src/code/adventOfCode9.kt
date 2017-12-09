package code

fun day9problem1(inputString: String): Any? {

    val toCharArray = inputString.toCharArray()
    var groupCount = 0
    var groupWeight = 1

    var skipNext = false
    var garbageMode = false

    for(char in toCharArray){
        if(skipNext){
            skipNext = false
            continue
        }
        if(char.equals('!')){
            skipNext = true
            continue
        }
        if(garbageMode){
            if(char.equals('>')){
                garbageMode = false
            }
            continue
        }
        if(char.equals('<')){
            garbageMode = true
            continue
        }

        if(char.equals('{')){
            groupCount += groupWeight
            groupWeight += 1
        }
        if(char.equals('}')){
            groupWeight -= 1
        }

    }

    return groupCount;
}




fun day9problem2(inputString: String): Any? {
    val toCharArray = inputString.toCharArray()
    var groupCount = 0
    var groupWeight = 1

    var garbageCount = 0

    var skipNext = false
    var garbageMode = false

    for(char in toCharArray){
        if(skipNext){
            skipNext = false
            continue
        }
        if(char.equals('!')){
            skipNext = true
            continue
        }
        if(garbageMode){
            if(char.equals('>')){
                garbageMode = false
            } else {
                garbageCount += 1
            }
            continue
        }
        if(char.equals('<')){
            garbageMode = true
            continue
        }

        if(char.equals('{')){
            groupCount += groupWeight
            groupWeight += 1
        }
        if(char.equals('}')){
            groupWeight -= 1
        }

    }

    return garbageCount
}