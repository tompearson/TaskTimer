package learnprogramming.academy.tasktimer

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by timbuchalka for the Android Oreo using Kotlin course
 * from www.learnprogramming.academy
 */
@Parcelize
data class Task(val name: String, val description: String, val sortOrder: Int, var id: Long = 0) : Parcelable