// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.timessquare;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

// Referenced classes of package com.squareup.timessquare:
//            CalendarPickerView

public class this._cls0
{

    final CalendarPickerView this$0;

    public this._cls0 inMode(this._cls0 _pcls0)
    {
        selectionMode = _pcls0;
        CalendarPickerView.access$300(CalendarPickerView.this);
        return this;
    }

    public this._cls0 withSelectedDate(Date date)
    {
        return withSelectedDates(Arrays.asList(new Date[] {
            date
        }));
    }

    public withSelectedDates withSelectedDates(Collection collection)
    {
        if (selectionMode == LE && collection.size() > 1)
        {
            throw new IllegalArgumentException("SINGLE mode can't be used with multiple selectedDates");
        }
        if (selectionMode == E && collection.size() > 2)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("RANGE mode only allows two selectedDates.  You tried to pass ").append(collection.size()).toString());
        }
        if (collection != null)
        {
            Date date;
            for (collection = collection.iterator(); collection.hasNext(); selectDate(date))
            {
                date = (Date)collection.next();
            }

        }
        CalendarPickerView.access$400(CalendarPickerView.this);
        CalendarPickerView.access$300(CalendarPickerView.this);
        return this;
    }

    public ()
    {
        this$0 = CalendarPickerView.this;
        super();
    }
}
