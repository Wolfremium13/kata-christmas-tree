package christmas

import dev.wolfremium.www.christmas.ChristmastimeGenerator
import dev.wolfremium.www.christmas.Printable
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class ChristmasTreeGeneratorShould {
    @Test
    fun `not allow negative levels`() {
        val printable = mock<Printable>()
        val treeGenerator = ChristmastimeGenerator(printable)
        val level = -1

        treeGenerator.generate(level)

        verify(printable).print("")
    }

    @Test
    fun `gives only the trunk when there is not enough level`(){
        val printable = mock<Printable>()
        val treeGenerator = ChristmastimeGenerator(printable)
        val level = 0

        treeGenerator.generate(level)

        verify(printable).print("|")
    }
}