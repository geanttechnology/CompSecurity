// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.app;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;

public class DatePickerDialogFragment extends DialogFragment
{
    public static class Builder
    {

        private final DatePickerDialogFragment building = new DatePickerDialogFragment();

        public DatePickerDialogFragment createFromActivity(int i, Activity activity)
        {
            building.setTargetFragment(null, i);
            building.listener = (android.app.DatePickerDialog.OnDateSetListener)activity;
            return building;
        }

        public DatePickerDialogFragment createFromFragment(int i, Fragment fragment)
        {
            building.setTargetFragment(fragment, i);
            building.listener = (android.app.DatePickerDialog.OnDateSetListener)fragment;
            return building;
        }

        public Builder setDay(int i)
        {
            building.day = i;
            return this;
        }

        public Builder setMonth(int i)
        {
            building.month = i;
            return this;
        }

        public Builder setYear(int i)
        {
            building.year = i;
            return this;
        }

        public Builder()
        {
        }
    }


    private int day;
    private android.app.DatePickerDialog.OnDateSetListener listener;
    private int month;
    private int year;

    public DatePickerDialogFragment()
    {
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        return new DatePickerDialog(getActivity(), listener, year, month, day);
    }


/*
    static int access$002(DatePickerDialogFragment datepickerdialogfragment, int i)
    {
        datepickerdialogfragment.year = i;
        return i;
    }

*/


/*
    static int access$102(DatePickerDialogFragment datepickerdialogfragment, int i)
    {
        datepickerdialogfragment.month = i;
        return i;
    }

*/


/*
    static int access$202(DatePickerDialogFragment datepickerdialogfragment, int i)
    {
        datepickerdialogfragment.day = i;
        return i;
    }

*/


/*
    static android.app.DatePickerDialog.OnDateSetListener access$302(DatePickerDialogFragment datepickerdialogfragment, android.app.DatePickerDialog.OnDateSetListener ondatesetlistener)
    {
        datepickerdialogfragment.listener = ondatesetlistener;
        return ondatesetlistener;
    }

*/
}
