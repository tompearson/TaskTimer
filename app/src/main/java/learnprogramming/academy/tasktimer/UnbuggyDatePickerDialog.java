package learnprogramming.academy.tasktimer;

import android.app.DatePickerDialog;
import android.content.Context;

/**
 *
 * Replacing tryNotifyDateSet() with nothing - this is a workaround for Android bug in API 4.x
 * @see <a href="https://issuetracker.google.com/issues/36951008"&gt;https://issuetracker.google.com/issues/36951008&lt;/a>
 *
 * Fix by Wojtek Jarosz.
 */
class UnbuggyDatePickerDialog extends DatePickerDialog {

    UnbuggyDatePickerDialog(Context context, OnDateSetListener callBack, int year, int monthOfYear, int dayOfMonth) {
        super(context, callBack, year, monthOfYear, dayOfMonth);
    }

    @Override
    protected void onStop() {
        // do nothing - do NOT call super method.
    }
}