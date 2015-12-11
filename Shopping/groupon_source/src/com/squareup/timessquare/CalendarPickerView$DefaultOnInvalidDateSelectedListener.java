// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.timessquare;

import android.content.res.Resources;
import android.widget.Toast;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

// Referenced classes of package com.squareup.timessquare:
//            CalendarPickerView

private class <init>
    implements <init>
{

    final CalendarPickerView this$0;

    public void onInvalidDateSelected(Date date)
    {
        date = getResources().getString(<init>, new Object[] {
            CalendarPickerView.access$2500(CalendarPickerView.this).format(CalendarPickerView.access$900(CalendarPickerView.this).getTime()), CalendarPickerView.access$2500(CalendarPickerView.this).format(CalendarPickerView.access$1000(CalendarPickerView.this).getTime())
        });
        Toast.makeText(getContext(), date, 0).show();
    }

    private ()
    {
        this$0 = CalendarPickerView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
