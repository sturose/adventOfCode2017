package code

data class Node(var name: String,
                var weight: Int,
                var combinedWeight: Int,
                var children: MutableList<Node>,
                var childrenNames: MutableList<String>,
                var root: Boolean) {
    constructor() : this("", 0, 0, mutableListOf(), mutableListOf(), true)


}