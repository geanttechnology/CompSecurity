// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import java.util.Calendar;
import java.util.GregorianCalendar;

// Referenced classes of package com.groupon.activity:
//            Gifting

protected class this._cls1 extends DatePickerDialog
{

    final this._cls1 this$1;

    public void onDateChanged(DatePicker datepicker, int i, int j, int k)
    {
        GregorianCalendar gregoriancalendar = new GregorianCalendar();
        gregoriancalendar.set(1, i);
        gregoriancalendar.set(2, j);
        gregoriancalendar.set(5, k);
        if (gregoriancalendar.before(Gifting.access$500(_fld1)))
        {
            datepicker.init(Gifting.access$500(_fld1).get(1), Gifting.access$500(_fld1).get(2), Gifting.access$500(_fld1).get(5), this);
            _mth1(Gifting.access$500(_fld1).get(1), Gifting.access$500(_fld1).get(2), Gifting.access$500(_fld1).get(5));
            super.onDateChanged(datepicker, Gifting.access$500(_fld1).get(1), Gifting.access$500(_fld1).get(2), Gifting.access$500(_fld1).get(5));
            return;
        }
        if (gregoriancalendar.after(Gifting.access$600(_fld1)))
        {
            datepicker.init(Gifting.access$600(_fld1).get(1), Gifting.access$600(_fld1).get(2), Gifting.access$600(_fld1).get(5), this);
            _mth1(Gifting.access$600(_fld1).get(1), Gifting.access$600(_fld1).get(2), Gifting.access$600(_fld1).get(5));
            super.onDateChanged(datepicker, Gifting.access$600(_fld1).get(1), Gifting.access$600(_fld1).get(2), Gifting.access$600(_fld1).get(5));
            return;
        } else
        {
            _mth1(i, j, k);
            super.onDateChanged(datepicker, i, j, k);
            return;
        }
    }

    public (Context context, android.app.erDialog erdialog, int i, int j, int k)
    {
        this$1 = this._cls1.this;
        super(context, erdialog, i, j, k);
    }
}
