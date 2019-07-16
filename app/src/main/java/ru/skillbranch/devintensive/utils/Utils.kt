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

    fun transliteration(payload: String, divider:String =" "): String {
        //TODO("not impl") //to
        return ""
    }

    fun toInitials(firstName: String?, lastName: String?): String? {

        val initials : String?
        initials = firstName?.elementAtOrNull(0).toString()

        return initials
    }
}