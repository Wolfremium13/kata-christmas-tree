package dev.wolfremium.www.christmas

class ChristmastimeGenerator(val printable: Printable) {
    fun generate(level: Int) {
        notPrintAnythingIfNegative(level)
        giveOnlyTheTrunkWhenLevelIsZero(level)
        if (level == 2) {
            generateTree(level)
        }
        if (level == 3) {
            generateTree(level)
        }

        if (level == 4) {
            generateTree(level)
        }
    }

    private fun generateTree(level: Int) {
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
        printable.print(treeLevels.joinToString(separator = "") { it })
    }

    private fun putTheTrunk(level: Int) = " ".repeat(level - 1) + "|"

    private fun giveOnlyTheTrunkWhenLevelIsZero(level: Int) {
        if (level == 0) {
            printable.print("|")
        }
    }

    private fun notPrintAnythingIfNegative(level: Int) {
        if (level < 0) {
            printable.print("")
        }
    }

}
