package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?> {

        return when (fullName?.trim()) {
            null, "", " " -> Pair(null, null)
            else -> {
                val parts: List<String>? = fullName?.trim().split(" ")

                val firstName = parts?.getOrNull(0)
                val lastName = parts?.getOrNull(1)
                firstName to lastName
            }
        }
    }

    fun transliteration(payload: String, divider: String = " "): String {
        var Newpayload: String = ""
        for (let in payload.trim()) Newpayload += when (let){
            ' ' -> divider
            let.toUpperCase() -> letters[let.toLowerCase()]?.toUpperCase()
            else -> letters[let]
        }

        return Newpayload
    }

    fun toInitials(firstName: String?, lastName: String?): String? {

        val elA = firstName?.toUpperCase()?.trim()?.firstOrNull()
        val elB = lastName?.toUpperCase()?.trim()?.firstOrNull()

        return if (elA == null && elB == null) "null"
        else "${elA?:""}${elB?:""}"
    }

    private val letters = mapOf(
    'а' to "a",
    'б' to "b",
    'в' to "v",
    'г' to "g",
    'д' to "d",
    'е' to "e",
    'ё' to "e",
    'ж' to "zh",
    'з' to "z",
    'и' to "i",
    'й' to "i",
    'к' to "k",
    'л' to "l",
    'м' to "m",
    'н' to "n",
    'о' to "o",
    'п' to "p",
    'р' to "r",
    'с' to "s",
    'т' to "t",
    'у' to "u",
    'ф' to "f",
    'х' to "h",
    'ц' to "c",
    'ч' to "ch",
    'ш' to "sh",
    'щ' to "sh'",
    'ъ' to "",
    'ы' to "i",
    'ь' to "",
    'э' to "e",
    'ю' to "yu",
    'я' to "ya"
    )
}