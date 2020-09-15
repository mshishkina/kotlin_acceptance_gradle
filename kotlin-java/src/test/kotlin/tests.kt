package demo 

import java.io.File
import kotlin.test.assertEquals
import org.junit.Test as test

class TestSource() {
    @test fun f() {
        val example : KotlinGreetingJoiner = KotlinGreetingJoiner(Greeter("Hi"))
        example.addName("Harry")
        example.addName("Ron")
        example.addName(null)
        example.addName("Hermione")

        assertEquals("Hi Harry and Ron and Hermione", example.getJoinedGreeting())
        File("run_results").appendText("f\n")
    }

    @test fun testFromDeploy(){
        val example = ExampleSource(5)
        assertEquals("Hello 5", example.editMe())
        File("run_results").appendText("testFromDeploy\n")
    }
}

