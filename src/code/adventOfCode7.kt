package code

import java.util.*

fun day7problem1(inputString: String): Any? {

    val lines = inputString.split("\n".toRegex())

    var values = ArrayList<Node>()
    for (line in lines) {
        values.add(toNode(line))
    }

    val root = assignChildren(values)

    calculateWeight(root)

    return root.name
}

fun calculateWeight(node: Node): Int {
    node.combinedWeight = node.weight
    if (node.children.isNotEmpty()) {
        for (child in node.children) {
            node.combinedWeight += calculateWeight(child)
        }
    }

    return node.combinedWeight
}

fun assignChildren(values: ArrayList<Node>): Node {
    for (node in values) {
        if (node.childrenNames.isNotEmpty()) {
            for (node2 in values) {
                if (node.childrenNames.contains(node2.name)) {
                    node.children.add(node2)
                    node2.root = false
                }
            }
        }
    }
    for (node in values) {
        if (node.root) {
            return node
        }
    }
    return Node()
}

fun toNode(line: String): Node {
    val segments = line.split(" ".toRegex())

    val node = Node()
    node.name = segments[0]
    val weightString = segments[1]
    node.weight = weightString.substringBefore(')').substringAfter('(').toInt()

    if (segments.size > 2) {
        for (i in 3..(segments.size - 1)) {
            node.childrenNames.add(segments[i].substringBefore(','))
        }
    }

    return node
}

fun day7problem2(inputString: String): Any? {

    val lines = inputString.split("\n".toRegex())

    var values = ArrayList<Node>()
    for (line in lines) {
        values.add(toNode(line))
    }

    val root = assignChildren(values)

    calculateWeight(root)

    return findWrongValue(root)
}

fun findWrongValue(node: Node) : Int {

    return  findOddManOut(node.children)
}

fun findOddManOut(children: MutableList<Node>) : Int {
    var weightCounts: MutableList<IntArray> = mutableListOf()
    for (node in children) {
        var found = false
        for (weightCount in weightCounts) {
            if (weightCount[0] == node.combinedWeight) {
                weightCount[1] += 1
                found = true
            }
        }
        if (!found) {
            var newWeightcount = intArrayOf(node.combinedWeight, 1)
            weightCounts.add(newWeightcount)
        }
    }

    var oddManOut = 0
    for (weightCount in weightCounts) {
        if(weightCount[1] == 1){
            for (node in children) {
                if(node.combinedWeight == weightCount[0]) {
                    oddManOut = findOddManOut(node.children)
                    if(oddManOut == 0){
                        for(child in children){
                            if(child != node){
                                return node.weight - (node.combinedWeight - child.combinedWeight)
                            }
                        }
                    }
                }
            }
        }
    }
    return oddManOut
}
