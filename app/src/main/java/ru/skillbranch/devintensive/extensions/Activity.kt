package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager

fun Activity.hideKeyboard() {
    //if (isKeyboardOpen()) {

        val view = this.currentFocus
        if (view != null) {
            (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(view.windowToken,0)
        }
    //}

}

fun Activity.isKeyboardOpen(): Boolean {

    val softKeyboardHeight = 100
    val rect = Rect()
    val rootView = window.decorView

    rootView.getWindowVisibleDisplayFrame(rect)

    val dm = rootView.resources.displayMetrics
    val heightDiff = rootView.bottom - rect.bottom
    return heightDiff > softKeyboardHeight * dm.density || heightDiff == 0

}

fun Activity.isKeyboardClosed(): Boolean {
    return !isKeyboardOpen()
}