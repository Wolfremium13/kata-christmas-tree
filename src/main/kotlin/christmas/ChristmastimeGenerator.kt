package dev.wolfremium.www.christmas

class ChristmastimeGenerator(val printable: Printable) {
    fun generate(level: Int) {
        notPrintAnythingIfNegative(level)
        giveOnlyTheTrunkWhenLevelIsZero(level)
        if (level == 2) {
            val tree = listOf(
                " ".repeat(1) + "x\n",
                " ".repeat(0) + "xxx\n",
                " ".repeat(1) + "|"
            )
            printable.print(tree.joinToString(separator = "") { it })
        }
        if (level == 3) {
            val tree = listOf(
                " ".repeat(2) + "x\n",
                " ".repeat(1) + "xxx\n",
                " ".repeat(0) + "xxxxx\n",
                " ".repeat(2) + "|"
            )
            printable.print(tree.joinToString(separator = "") { it })
        }

        if (level == 4) {
            val tree = listOf(
                " ".repeat(3) + "x\n",
                " ".repeat(2) + "xxx\n",
                " ".repeat(1) + "xxxxx\n",
                " ".repeat(0) + "xxxxxxx\n",
                " ".repeat(3) + "|"
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
