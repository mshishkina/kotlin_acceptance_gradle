package demo 

class ExampleSource(param: Int) {
    val property = param

    fun editMe(): String {
        return "Hello $property"
    }
}
