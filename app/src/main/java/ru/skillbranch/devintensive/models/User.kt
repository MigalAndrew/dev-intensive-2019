package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = Date(),
    val isOnline: Boolean = false
) {

    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id: String) : this(id, "John", "Doe")

    init {
        println(
            "It's Alive!!! \n" +
                    "${if (lastName === "Doe") "His name is $firstName $lastName" else "And his name is $firstName $lastName"}\n"
        )
    }

    companion object Factory {
        private var lastId: Int = -1
        fun makeUser(fullName: String?): User {
            lastId++

            val (firstName, lastName) = Utils.parseFullName(fullName)

            return User(id = "$lastId", firstName = firstName, lastName = lastName)

        }

    }

    class Builder(
        var id: String = "0",
        var firstName: String? = null,
        var lastName: String? = null,
        var avatar: String? = null,
        var rating: Int = 0,
        var respect: Int = 0,
        var lastVisit: Date? = Date(),
        var isOnline: Boolean = false
    ){
        fun id(id: String) =apply {this.id = id}
        fun firstName(firstName: String?)=apply  {this.firstName = firstName}
        fun lastName(s:String)=apply  {this.lastName = s}
        fun avatar(s:String)=apply  {this.avatar = s}
        fun rating(n:Int)=apply  {this.rating = n}
        fun respect(n:Int)=apply  {this.respect = n}
        fun lastVisit(d:Date)=apply  {this.lastVisit = d}
        fun isOnline(b:Boolean)=apply  {this.isOnline = b}

        fun build() = User(id, firstName, lastName, avatar, rating, respect, lastVisit, isOnline)

    }

//    **Паттерн Builder
//    Необходимо реализовать Builder для класса User
//    +2
//    Реализуй паттерн Builder для класса User.
//    User.Builder().id(s)
//    .firstName(s)
//    .lastName(s)
//    .avatar(s)
//    .rating(n)
//    .respect(n)
//    .lastVisit(d)
//    .isOnline(b)
//    .build() должен вернуть объект User

}