package dev.wolfremium.www.christmas

class ChristmastimeGenerator(private val printable: Printable) {
    fun generate(treeLevels: Int) {
        if (treeLevels < 0) {
            printable.print("")
            return
        }
        if (treeLevels == 0) {
            printable.print(putTheTrunk(1))
            return
        }
        printable.print(generateTree(treeLevels))
    }

    private fun generateTree(level: Int): String {
        val treeLevels = ArrayList<String>()
        var leafsCounter = 1
        IntArray(level) { level - it }.forEach { leafLevel ->
            val spaceRepetitions = leafLevel - 1
            val leafRepetitions = leafsCounter
            val leaf = "x"
            treeLevels.add(" ".repeat(spaceRepetitions) + leaf.repeat(leafRepetitions) + "\n")
            leafsCounter += 2
        }
        treeLevels.add(putTheTrunk(level))
        return treeLevels.joinToString(separator = "") { it }
    }

    private fun putTheTrunk(level: Int) = " ".repeat(level - 1) + "|"

}
