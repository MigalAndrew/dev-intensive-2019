package ru.skillbranch.devintensive.extensions

fun String.truncate(len:Int = 16):String {

    return if (this.length>len) "${this.substring(0,len).trimEnd()}..." else this

}

fun String.stripHtml():String{
    return this.trim()
        .replace("<.*?>".toRegex(),"")
        .replace("[&<>'\"]".toRegex(),"")
        .replace("\\s+".toRegex(), " ")
}