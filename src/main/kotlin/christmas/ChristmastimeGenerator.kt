package dev.wolfremium.www.christmas

class ChristmastimeGenerator(val printable: Printable) {
    fun generate(level: Int) {
        notPrintAnythingIfNegative(level)
        giveOnlyTheTrunkWhenLevelIsZero(level)
        if (level == 2) {
            val tree = listOf(
                " ".repeat(level - 1) + "x".repeat(1) + "\n",
                " ".repeat(0) + "x".repeat(3) + "\n",
                putTheTrunk(level)
            )
            printable.print(tree.joinToString(separator = "") { it })
        }
        if (level == 3) {
            val tree = listOf(
                " ".repeat(level - 1) + "x".repeat(1) + "\n",
                " ".repeat(level - 2) + "x".repeat(3) + "\n",
                " ".repeat(0) + "x".repeat(5) + "\n",
                putTheTrunk(level)
            )
            printable.print(tree.joinToString(separator = "") { it })
        }

        if (level == 4) {
            val treeLevels = ArrayList<String>()
            var leafsCounter = 1
            IntArray(level) { level - it }.forEach { leafLevel ->
                val spaceRepetitions = leafLevel - 1
                val leafRepetitions = leafsCounter
                treeLevels.add(" ".repeat(spaceRepetitions) + "x".repeat(leafRepetitions) + "\n")
                leafsCounter += 2
            }
            treeLevels.add(putTheTrunk(level))
            printable.print(treeLevels.joinToString(separator = "") { it })
        }
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
