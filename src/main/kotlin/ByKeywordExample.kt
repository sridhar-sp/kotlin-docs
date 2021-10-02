import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

val rocketFuelCapacity: Int by injectRocketFuelCapacity()

private fun injectRocketFuelCapacity() = DefaultRocketFuel()

private class DefaultRocketFuel : ReadOnlyProperty<Nothing?,Int> {
    // {@code rocketFuelCapacity} is a val hence only getValue is implemented.
    override fun getValue(thisRef: Nothing?, property: KProperty<*>): Int {
        return 78
    }
}

var rocketTyrePressure:Int by injectRocketTyrePressure()

private fun injectRocketTyrePressure() = RocketTyrePressureSystem()

private class RocketTyrePressureSystem  : ReadWriteProperty<Nothing?, Int> {

    private var tyrePressure:Int = 25

    override fun getValue(thisRef: Nothing?, property: KProperty<*>): Int {
        return tyrePressure
    }

    override fun setValue(thisRef: Nothing?, property: KProperty<*>, value: Int) {
        //Set value
        tyrePressure=value
        // Perform other task like notifying other modules.
    }
}

fun main(args: Array<String>?) {
    println("Rocket fuel capacity $rocketFuelCapacity")

    println("Rocket tyre pressure before update $rocketTyrePressure")
    rocketTyrePressure = 85;
    println("Rocket tyre pressure after update $rocketTyrePressure")

}