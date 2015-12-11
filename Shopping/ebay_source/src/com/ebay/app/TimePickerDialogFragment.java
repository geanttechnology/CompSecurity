// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.app;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;

public class TimePickerDialogFragment extends DialogFragment
{
    public static class Builder
    {

        private int hourOfDay;
        private int minute;

        public TimePickerDialogFragment createFromActivity(int i)
        {
            TimePickerDialogFragment timepickerdialogfragment = new TimePickerDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("hour", hourOfDay);
            bundle.putInt("minute", minute);
            timepickerdialogfragment.setArguments(bundle);
            timepickerdialogfragment.setTargetFragment(null, i);
            return timepickerdialogfragment;
        }

        public TimePickerDialogFragment createFromFragment(int i, Fragment fragment)
        {
            TimePickerDialogFragment timepickerdialogfragment = createFromActivity(i);
            timepickerdialogfragment.setTargetFragment(fragment, i);
            return timepickerdialogfragment;
        }

        public Builder setHour(int i)
        {
            hourOfDay = i;
            return this;
        }

        public Builder setMinute(int i)
        {
            minute = i;
            return this;
        }

        public Builder()
        {
        }
    }


    private static final String HOUR = "hour";
    private static final String MINUTE = "minute";
    private int hourOfDay;
    private int minute;

    public TimePickerDialogFragment()
    {
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        hourOfDay = getArguments().getInt("hour");
        minute = getArguments().getInt("minute");
        boolean flag = DateFormat.is24HourFormat(getActivity());
        return new TimePickerDialog(getActivity(), (android.app.TimePickerDialog.OnTimeSetListener)getTargetFragment(), hourOfDay, minute, flag);
    }
}
