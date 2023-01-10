fun main() {

    val user1 = User(20)
    val user2 = User(62)
    val user3 = User(3700)
    val user4 = User(87000)
    val user5 = User(175000)
    val user6 = User(300000)
    user1.agoToText()
    user2.agoToText()
    user3.agoToText()
    user4.agoToText()
    user5.agoToText()
    user6.agoToText()
}

class User constructor(private val lastVisitInSec: Int) {

    fun agoToText() {

        val minute = lastVisitInSec / 60
        val hour = lastVisitInSec / 3600

        when (lastVisitInSec) {
            in 0..60 -> println("был(а) только что")
            in 61..3600 -> println("был(а) $minute ${minuteWord(lastVisitInSec)} назад")
            in 3601..86400 -> println("был(а) $hour ${hourWord(lastVisitInSec)} назад")
            in 86401..172800 -> println("был(а) вчера")
            in 172800..259200 -> println("был(а) позавчера")
            else -> print("был(а) давно")
        }
    }

    fun minuteWord(lastVisitInSec: Int): String {
        val minute: Int = lastVisitInSec / 60
        val case = when (Math.abs(minute % 10)) {
            0 -> "минут"
            1 -> if (minute == 11) "минут" else "минуту"
            in 2..4 -> if (minute >= 12 && minute <= 14) "минут" else "минуты"
            in 5..9 -> "минут"
            else -> ""
        }
        return case
    }

    fun hourWord(lastVisitInSec: Int): String {
        val hour: Int = lastVisitInSec / 3600
        val case = when (Math.abs(hour % 10)) {
            0 -> "часов"
            1 -> if (hour != 11) "час" else "часов"
            2 -> if (hour != 12) "часа" else "часов"
            3 -> if (hour != 13) "часа" else "часов"
            4 -> if (hour != 14) "часа" else "часов"
            in 5..9 -> "часов"
            else -> ""
        }
        return case
    }

}
