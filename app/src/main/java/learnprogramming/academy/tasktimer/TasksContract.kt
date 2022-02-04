package learnprogramming.academy.tasktimer

import android.content.ContentUris
import android.net.Uri
import android.provider.BaseColumns

/**
 * Created by timbuchalka for the Android Oreo using Kotlin course
 * from www.learnprogramming.academy
 */
object TasksContract {

    internal const val TABLE_NAME = "Tasks"

    /**
     * The URI to access the Tasks table.
     */
    val CONTENT_URI: Uri = Uri.withAppendedPath(CONTENT_AUTHORITY_URI, TABLE_NAME)

    const val CONTENT_TYPE = "vnd.android.cursor.dir/vnd.$CONTENT_AUTHORITY.$TABLE_NAME"
    const val CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.$CONTENT_AUTHORITY.$TABLE_NAME"

    // Tasks fields
    object Columns {
        const val ID = BaseColumns._ID
        const val TASK_NAME = "Name"
        const val TASK_DESCRIPTION = "Description"
        const val TASK_SORT_ORDER = "SortOrder"
    }

    fun getId(uri: Uri): Long {
        return ContentUris.parseId(uri)
    }

    fun buildUriFromId(id: Long): Uri {
        return ContentUris.withAppendedId(CONTENT_URI, id)
    }

}