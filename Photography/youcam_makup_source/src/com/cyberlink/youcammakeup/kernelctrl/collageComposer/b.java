// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.collageComposer;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.collageComposer:
//            d, c

public class b
{

    private List a;
    private DatePickerDialog b;
    private long c;

    public b()
    {
        b = null;
        c = System.currentTimeMillis();
        a = new LinkedList();
    }

    static long a(b b1, long l)
    {
        b1.c = l;
        return l;
    }

    static List a(b b1)
    {
        return b1.a;
    }

    static long b(b b1)
    {
        return b1.c;
    }

    public void a()
    {
        a = new LinkedList();
    }

    public void a(Context context)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(c);
        if (b == null)
        {
            Object obj = new d(this);
            b = new DatePickerDialog(context, ((android.app.DatePickerDialog.OnDateSetListener) (obj)), calendar.get(1), calendar.get(2), calendar.get(5));
            b.setOnShowListener(((android.content.DialogInterface.OnShowListener) (obj)));
            b.setOnCancelListener(((android.content.DialogInterface.OnCancelListener) (obj)));
            b.setOnDismissListener(((android.content.DialogInterface.OnDismissListener) (obj)));
            context = Calendar.getInstance();
            context.set(1900, 0, 1, 0, 0, 0);
            obj = Calendar.getInstance();
            ((Calendar) (obj)).set(2100, 11, 31, 23, 59, 59);
            b.getDatePicker().setMinDate(context.getTimeInMillis());
            b.getDatePicker().setMaxDate(((Calendar) (obj)).getTimeInMillis());
        }
        b.updateDate(calendar.get(1), calendar.get(2), calendar.get(5));
        b.show();
    }

    public void a(c c1)
    {
        a.add(c1);
    }

    public long b()
    {
        return c;
    }
}
