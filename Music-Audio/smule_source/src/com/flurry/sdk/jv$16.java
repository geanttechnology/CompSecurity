// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.Calendar;
import java.util.GregorianCalendar;

// Referenced classes of package com.flurry.sdk:
//            ir, jv, jx, jy, 
//            jz

final class lendar extends ir
{

    public Calendar a(jx jx1)
    {
        int j = 0;
        if (jx1.f() == jy.i)
        {
            jx1.j();
            return null;
        }
        jx1.c();
        int k = 0;
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        int k1 = 0;
        do
        {
            if (jx1.f() == jy.d)
            {
                break;
            }
            String s = jx1.g();
            int i = jx1.m();
            if ("year".equals(s))
            {
                k1 = i;
            } else
            if ("month".equals(s))
            {
                j1 = i;
            } else
            if ("dayOfMonth".equals(s))
            {
                i1 = i;
            } else
            if ("hourOfDay".equals(s))
            {
                l = i;
            } else
            if ("minute".equals(s))
            {
                k = i;
            } else
            if ("second".equals(s))
            {
                j = i;
            }
        } while (true);
        jx1.d();
        return new GregorianCalendar(k1, j1, i1, l, k, j);
    }

    public volatile void a(jz jz1, Object obj)
    {
        a(jz1, (Calendar)obj);
    }

    public void a(jz jz1, Calendar calendar)
    {
        if (calendar == null)
        {
            jz1.f();
            return;
        } else
        {
            jz1.d();
            jz1.a("year");
            jz1.a(calendar.get(1));
            jz1.a("month");
            jz1.a(calendar.get(2));
            jz1.a("dayOfMonth");
            jz1.a(calendar.get(5));
            jz1.a("hourOfDay");
            jz1.a(calendar.get(11));
            jz1.a("minute");
            jz1.a(calendar.get(12));
            jz1.a("second");
            jz1.a(calendar.get(13));
            jz1.e();
            return;
        }
    }

    public Object b(jx jx1)
    {
        return a(jx1);
    }

    lendar()
    {
    }
}
