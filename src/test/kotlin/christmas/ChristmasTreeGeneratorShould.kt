package christmas

import dev.wolfremium.www.christmas.ChristmastimeGenerator
import dev.wolfremium.www.christmas.Printable
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class ChristmasTreeGeneratorShould {
    private lateinit var printable: Printable
    private lateinit var treeGenerator: ChristmastimeGenerator

    @BeforeEach
    fun setup() {
        printable = mock<Printable>()
        treeGenerator = ChristmastimeGenerator(printable)
    }

    @Test
    fun `not allow negative levels`() {
        val level = -1

        treeGenerator.generate(level)

        verify(printable).print("")
    }

    @Test
    fun `gives only the trunk when there is not enough level`() {
        val level = 0

        treeGenerator.generate(level)

        verify(printable).print("|")
    }

    @Test
    fun `generate an small tree when level is low`() {
        val lowLevel = 2

        treeGenerator.generate(lowLevel)

        val smallTree = """
             x
            xxx
             |
        """.trimIndent()
        verify(printable).print(smallTree)
    }

    @Test
    fun `generate a medium size tree when level is medium`() {
        val mediumLevel = 3

        treeGenerator.generate(mediumLevel)

        val mediumTree = """
              x
             xxx
            xxxxx
              |
        """.trimIndent()
        verify(printable).print(mediumTree)
    }

    @Test
    fun `generate a high size tree when level is high`(){
        val highLevel = 4

        treeGenerator.generate(highLevel)

        val highTree = """
              x
             xxx
            xxxxx
           xxxxxxx
              |
        """.trimIndent()
        verify(printable).print(highTree)
    }
}