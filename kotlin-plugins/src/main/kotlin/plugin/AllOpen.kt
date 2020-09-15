package plugin

annotation class OpenClass

@OpenClass class ImplicitlyOpen
class OpenChecker : ImplicitlyOpen()
