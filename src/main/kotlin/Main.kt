const val TIME_IN_SECONDS: Int = 300
const val TIME_IN_SECONDS_2: Int = 120
const val TIME_IN_SECONDS_3: Int = 4_000
const val TIME_IN_SECONDS_4: Int = 7_500
const val TIME_IN_SECONDS_5: Int = 39_600
const val TIME_IN_SECONDS_6: Int = 90_000
const val TIME_IN_SECONDS_7: Int = 300_000

const val DAY_IN_SECONDS: Int = 60 * 60 * 24
const val HOUR_IN_SECONDS: Int = 60 * 60

fun main() {

    println("Был в сети ${agoToText(TIME_IN_SECONDS)}")
    println("Был в сети ${agoToText(TIME_IN_SECONDS_2)}")
    println("Был в сети ${agoToText(TIME_IN_SECONDS_3)}")
    println("Был в сети ${agoToText(TIME_IN_SECONDS_4)}")
    println("Был в сети ${agoToText(TIME_IN_SECONDS_5)}")
    println("Был в сети ${agoToText(TIME_IN_SECONDS_6)}")
    println("Был в сети ${agoToText(TIME_IN_SECONDS_7)}")

}

fun agoToText(timeInSeconds: Int) = when (timeInSeconds) {
    in 0..60 -> "только что"
    in 61..HOUR_IN_SECONDS -> "${minutes(timeInSeconds)}"
    in (HOUR_IN_SECONDS + 1)..DAY_IN_SECONDS -> "${hours(timeInSeconds)}"
    in (DAY_IN_SECONDS + 1)..DAY_IN_SECONDS * 2 -> " сегодня"
    in (DAY_IN_SECONDS * 2 + 1)..DAY_IN_SECONDS * 3 -> " вчера"
    else -> " давно"
}

fun minutes(timeInSeconds: Int) = when {
    convertToMinutes(timeInSeconds) % 100 == 11 -> "${convertToMinutes(timeInSeconds)} минут назад"
    convertToMinutes(timeInSeconds) % 10 == 1 -> " ${convertToMinutes(timeInSeconds)} минуту назад"
    convertToMinutes(timeInSeconds) % 10 in 2..4 -> " ${convertToMinutes(timeInSeconds)} минуты назад"
    else -> " ${convertToMinutes(timeInSeconds)} минут назад"
}

fun hours(timeInSeconds: Int) = when {
    convertToHour(timeInSeconds) % 100 == 11 -> " ${convertToHour(timeInSeconds)} часов назад"
    convertToHour(timeInSeconds) % 10 == 1 -> " ${convertToHour(timeInSeconds)} час назад"
    convertToHour(timeInSeconds) % 10 in 2..4 -> " ${convertToHour(timeInSeconds)} часа назад"
    else -> " ${convertToHour(timeInSeconds)} часов назад"
}

fun convertToMinutes(timeInSeconds: Int): Int {
    return timeInSeconds / 60
}

fun convertToHour(timeInSeconds: Int): Int {
    return timeInSeconds / 60 / 60
}

