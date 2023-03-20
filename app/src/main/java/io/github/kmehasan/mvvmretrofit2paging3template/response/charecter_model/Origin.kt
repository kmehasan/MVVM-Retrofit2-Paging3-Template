package io.github.kmehasan.mvvmretrofit2paging3template.response.charecter_model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Origin(
    val name: String,
    val url: String
):Parcelable