package com.example.shoestore.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Login(
    private val userName: String?,
    private val password: String?
) : Parcelable
