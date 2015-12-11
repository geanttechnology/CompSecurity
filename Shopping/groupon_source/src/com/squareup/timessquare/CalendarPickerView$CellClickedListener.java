// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.timessquare;


// Referenced classes of package com.squareup.timessquare:
//            CalendarPickerView, MonthCellDescriptor

private class <init>
    implements <init>
{

    final CalendarPickerView this$0;

    public void handleClick(MonthCellDescriptor monthcelldescriptor)
    {
        java.util.Date date = monthcelldescriptor.getDate();
        if (CalendarPickerView.access$800(CalendarPickerView.this) == null || !CalendarPickerView.access$800(CalendarPickerView.this).onCellClicked(date)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (CalendarPickerView.betweenDates(date, CalendarPickerView.access$900(CalendarPickerView.this), CalendarPickerView.access$1000(CalendarPickerView.this)) && CalendarPickerView.access$1100(CalendarPickerView.this, date))
        {
            break; /* Loop/switch isn't completed */
        }
        if (CalendarPickerView.access$1200(CalendarPickerView.this) != null)
        {
            CalendarPickerView.access$1200(CalendarPickerView.this).onInvalidDateSelected(date);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        boolean flag = CalendarPickerView.access$1300(CalendarPickerView.this, date, monthcelldescriptor);
        if (CalendarPickerView.access$1400(CalendarPickerView.this) != null)
        {
            if (flag)
            {
                CalendarPickerView.access$1400(CalendarPickerView.this).onDateSelected(date);
                return;
            } else
            {
                CalendarPickerView.access$1400(CalendarPickerView.this).onDateUnselected(date);
                return;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private er()
    {
        this$0 = CalendarPickerView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
