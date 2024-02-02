package dev.wolfremium.www.christmas

class ChristmastimeGenerator(val printable: Printable) {
    fun generate(level: Int) {
        notPrintAnythingIfNegative(level)
        giveOnlyTheTrunkWhenLevelIsZero(level)
        if (level == 2) {
            val tree = listOf(
                " ".repeat(1) + "x".repeat(1) + "\n",
                " ".repeat(0) + "x".repeat(3) + "\n",
                " ".repeat(1) + "x".repeat(0) + "|"
            )
            printable.print(tree.joinToString(separator = "") { it })
        }
        if (level == 3) {
            val tree = listOf(
                " ".repeat(2) + "x".repeat(1) + "\n",
                " ".repeat(1) + "x".repeat(3) + "\n",
                " ".repeat(0) + "x".repeat(5) + "\n",
                " ".repeat(2) + "x".repeat(0) + "|"
            )
            printable.print(tree.joinToString(separator = "") { it })
        }

        if (level == 4) {
            val tree = listOf(
                " ".repeat(3) + "x".repeat(1) + "\n",
                " ".repeat(2) + "x".repeat(3) + "\n",
                " ".repeat(1) + "x".repeat(5) + "\n",
                " ".repeat(0) + "x".repeat(7) + "\n",
                " ".repeat(3) + "x".repeat(0) + "|"
            )
            printable.print(tree.joinToString(separator = "") { it })
        }
    }

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
