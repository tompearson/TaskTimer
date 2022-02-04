package learnprogramming.academy.tasktimer

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

/**
 * Created by timbuchalka for the Android Oreo using Kotlin course
 * from www.learnprogramming.academy
 */

fun FragmentActivity.findFragmentById(id: Int): Fragment? {
    return supportFragmentManager.findFragmentById(id)
}

fun FragmentActivity.showConfirmationDialog(id: Int,
                                            message: String,
                                            positiveCaption: Int = R.string.ok,
                                            negativeCaption: Int = R.string.cancel) {
    val args = Bundle().apply {
        putInt(DIALOG_ID, id)
        putString(DIALOG_MESSAGE, message)
        putInt(DIALOG_POSITIVE_RID, positiveCaption)
        putInt(DIALOG_NEGATIVE_RID, negativeCaption)
    }
    val dialog = AppDialog()
    dialog.arguments = args
    dialog.show(this.supportFragmentManager, null)
}

        /**
        * Extensions based on an article by Dinesh Babuhunky
        * at https://medium.com/thoughts-overflow/how-to-add-a-fragment-in-kotlin-way-73203c5a450b
        */

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
            beginTransaction().func().commit()
        }

fun FragmentActivity.addFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { add(frameId, fragment)}
}

fun FragmentActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction{ replace(frameId, fragment)}
}

fun FragmentActivity.removeFragment(fragment: Fragment) {
    supportFragmentManager.inTransaction { remove(fragment)}
}

