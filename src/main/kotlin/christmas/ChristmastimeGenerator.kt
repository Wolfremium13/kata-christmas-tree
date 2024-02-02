package dev.wolfremium.www.christmas

class ChristmastimeGenerator(val printable: Printable) {
    fun generate(level: Int) {
        notPrintAnythingIfNegative(level)
        giveOnlyTheTrunkWhenLevelIsZero(level)
        if (level == 2) {
            val tree = listOf(
                " x\n",
                "xxx\n",
                " |"
            )
            printable.print(tree.joinToString(separator = "") { it })
        }
        if (level == 3) {
            printable.print(
                """
                 x
                xxx
               xxxxx
                 |
            """.trimIndent()
            )
        }

        if (level == 4) {
            printable.print(
                """
                 x
                xxx
               xxxxx
              xxxxxxx
                 |
            """.trimIndent()
            )
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
