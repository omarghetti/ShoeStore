package com.example.shoestore.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Login(
    val userName: String?,
    val password: String?
) : Parcelable
