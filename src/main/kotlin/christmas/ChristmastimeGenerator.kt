package dev.wolfremium.www.christmas

class ChristmastimeGenerator(val printable: Printable) {
    fun generate(level: Int) {
        if (level < 0) {
            printable.print("")
        }
        if (level == 0) {
            printable.print("|")
        }
        if (level == 2) {
            printable.print("""
                 x
                xxx
                 |
            """.trimIndent()
            )
        }
    }

}
