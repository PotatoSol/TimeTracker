package Employee

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.time.Duration

//All times should be accurate to the minute and calculated using minutes
class Employee(
    val name: String, //Format: FirstName MiddleName LastName [Spaced if necessary]
    val koreanName: String, //Korean name can be left void
    var pin: Int, //default to last 4 digits of social
    var expectedHours: Duration, //hours expected that the employee works in a Pay Period (2 weeks)
    var salaried: Boolean,
    var type: String, //W2 or 1099
    var id: String, //Format: LastName + [Last 4 digits of SSN]
    var clockIn: LocalDateTime, //Clock in and Clock out times for employee
    var clockOut: LocalDateTime //Replaced often (daily), only used for calculating one day
    ){

    var currentHours = Duration.ZERO

    val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a")

    fun changePin(newPin: Int) {
        pin = newPin
    }

    fun addDailyHours(){
        currentHours = currentHours.plus(Duration.between(clockIn,clockOut))
    }

    fun calculateHours(): Duration {
        if (salaried) { //returns the expected hours if salaried
            return expectedHours
        }
        else if (currentHours < expectedHours) { //if under expected hours, return current
            return currentHours
        } else {
            return Duration.ZERO
        }
    }

}

