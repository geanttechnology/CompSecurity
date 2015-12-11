// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import java.util.Calendar;
import roboguice.util.Strings;

public class ExpirationDatePickerDialog extends DatePickerDialog
    implements android.widget.DatePicker.OnDateChangedListener
{

    private static final String SELECTED_DATE = "Selected Date: ";
    private Calendar calendarInstance;
    private int month;
    private android.app.DatePickerDialog.OnDateSetListener onDateSetCallback;
    private DatePicker picker;
    private int year;

    public ExpirationDatePickerDialog(Context context, android.app.DatePickerDialog.OnDateSetListener ondatesetlistener, int i, int j, int k)
    {
        super(context, null, i, j, k);
        year = i;
        month = j;
        onDateSetCallback = ondatesetlistener;
        setView(LayoutInflater.from(context).inflate(0x7f0300b9, null));
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == -1)
        {
            updateDate(picker.getYear(), picker.getMonth(), picker.getDayOfMonth());
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        picker = (DatePicker)findViewById(0x7f10020b);
        calendarInstance = Calendar.getInstance();
        int i = Resources.getSystem().getIdentifier("day", "id", "android");
        if (i != 0)
        {
            bundle = picker.findViewById(i);
            if (bundle != null)
            {
                bundle.setVisibility(8);
            }
        }
        picker.init(year, month, calendarInstance.get(5), this);
    }

    public void onDateChanged(DatePicker datepicker, int i, int j, int k)
    {
        j++;
        if (j < 10)
        {
            datepicker = (new StringBuilder()).append("0").append(j).toString();
        } else
        {
            datepicker = Integer.valueOf(j);
        }
        datepicker = Strings.toString(datepicker);
        datepicker = (new StringBuilder()).append(datepicker).append("/").append(Strings.toString(Integer.valueOf(i)).substring(2, 4)).toString();
        setTitle((new StringBuilder()).append("Selected Date: ").append(datepicker).toString());
    }

    public void updateDate(int i, int j, int k)
    {
        onDateSetCallback.onDateSet(getDatePicker(), i, j, k);
    }
}
