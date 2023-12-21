package people

class Employee(
    val name: String,
    var pin: Int,
    var expectedHours: Double,
    var salaried: Boolean  ) {

    var currentHours: Double = 0.0

    fun changePin(newPin: Int){
        pin = newPin
    }

    fun enterHours(inputHours: Double){
        currentHours = inputHours
    }

    fun calculateHours(): Double{
        if(salaried){ //returns the expected hours if salaried
            return expectedHours;
        }
        else if(currentHours < expectedHours){ //if under expected hours, return current
            return currentHours
        }
        else {
            return 0.0
        }
    }

}