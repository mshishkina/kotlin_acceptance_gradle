package demo 

import kotlin.test.assertEquals
import org.junit.Test

class PureCheck {
    @Test fun f() {
        assertEquals("Hello, world!", getGreeting())
    }
}
