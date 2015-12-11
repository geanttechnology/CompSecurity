// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.app.FragmentManager;
import com.target.ui.fragment.common.a;
import com.wdullaer.materialdatetimepicker.date.b;
import java.util.Calendar;
import java.util.Date;

public class ag
{
    public static interface a
    {

        public abstract void a(Date date);
    }


    private static final String TAG = com/target/ui/util/ag.getSimpleName();

    public ag()
    {
    }

    public static void a(FragmentManager fragmentmanager, Date date, a a1)
    {
        a1 = new com.wdullaer.materialdatetimepicker.date.b.b(a1) {

            final a val$listener;

            public void a(b b, int i, int j, int k)
            {
                b = Calendar.getInstance();
                b.set(2, j);
                b.set(1, i);
                b.set(5, k);
                b = b.getTime();
                listener.a(b);
            }

            
            {
                listener = a1;
                super();
            }
        };
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        com.target.ui.fragment.common.a.a(a1, calendar.get(1), calendar.get(2), calendar.get(5)).show(fragmentmanager, TAG);
    }

}
