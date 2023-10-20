package com.zezzi.composegrid

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Event(
    var name: String,
    val availableSeats: Int,
)