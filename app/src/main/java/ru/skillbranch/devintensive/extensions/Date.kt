package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND) : Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date: Date = Date()): String {
    var delta = date.time - this.time
    val isPast: Boolean = delta > 0
    val result: String

    if (delta < 0) delta *= -1; delta += 20

    result = when {
        delta <= SECOND -> return "только что"
        delta > SECOND && delta <= SECOND * 45 -> "несколько секунд"
        delta > SECOND * 45 && delta <= SECOND * 75 -> "минуту"
        delta > SECOND * 75 && delta <= MINUTE * 45 -> TimeUnits.MINUTE.pluralTime((delta / MINUTE).toInt())
        delta > MINUTE * 45 && delta <= MINUTE * 75 -> "час"
        delta > MINUTE * 75 && delta <= HOUR * 22 -> TimeUnits.HOUR.pluralTime((delta / HOUR).toInt())
        delta > HOUR * 22 && delta <= HOUR * 26 -> "день"
        delta > HOUR * 26 && delta <= DAY * 360 -> TimeUnits.DAY.pluralTime((delta / DAY).toInt())
        delta > DAY * 360 -> return if (isPast) "более года назад" else "более чем через год"
        else -> return ""
    }

    return if (isPast) "$delta $result назад" else "$delta через $result"
}

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY;

    fun pluralTime(time:Int):String{
        return when (this){
            SECOND -> "$time ${when {
                time == 1 || time % 10 == 1 -> "секунду"
                time in 2..4 || time % 10 in 2..4 -> "секунды"
                else -> "секунд"
            }}"
            MINUTE -> "$time ${when {
                time == 1 || time % 10 == 1 -> "минуту"
                time in 2..4 || time % 10 in 2..4 -> "минуты"
                else -> "минут"
            }}"
            HOUR -> "$time ${when {
                time == 1 || time % 10 == 1 -> "час"
                time in 2..4 || time % 10 in 2..4 -> "часа"
                else -> "часов"
            }}"
            DAY -> "$time ${when {
                time == 1 || time % 10 == 1 -> "день"
                time in 2..4 || time % 10 in 2..4 -> "дня"
                else -> "дней"
            }}"


        }

    }
}