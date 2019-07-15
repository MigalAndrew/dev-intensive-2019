package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?> {

        return when (fullName) {
            null, "", " " -> Pair(null, null)
            else -> {
                val parts: List<String>? = fullName?.split(" ")

                val firstName = parts?.getOrNull(0)
                val lastName = parts?.getOrNull(1)
                firstName to lastName
            }
        }


    }

    fun transliteration(payload: String, divider:String =" "): String {
        //TODO("not impl") //to
        return ""
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        //TODO("not impl") //to
        return ""
    }
}