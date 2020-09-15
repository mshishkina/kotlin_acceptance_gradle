package plugin

import kotlin.test.assertEquals
import org.junit.Test

class NoArgTest {
    @Test fun testNoArg() {
        assertEquals(1, NoNoArg::class.java.constructors.size)
        assertEquals(2, ImplicitlyNoArg::class.java.constructors.size)
    }
}
