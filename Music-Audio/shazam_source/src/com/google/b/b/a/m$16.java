// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.d.a;
import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.x;
import java.util.Calendar;
import java.util.GregorianCalendar;

// Referenced classes of package com.google.b.b.a:
//            m

static final class endar extends x
{

    public final Object a(a a1)
    {
        int j = 0;
        if (a1.f() == b.i)
        {
            a1.k();
            return null;
        }
        a1.c();
        int k = 0;
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        int k1 = 0;
        do
        {
            if (a1.f() == b.d)
            {
                break;
            }
            String s = a1.h();
            int i = a1.n();
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
        a1.d();
        return new GregorianCalendar(k1, j1, i1, l, k, j);
    }

    public final void a(c c1, Object obj)
    {
        obj = (Calendar)obj;
        if (obj == null)
        {
            c1.f();
            return;
        } else
        {
            c1.d();
            c1.a("year");
            c1.a(((Calendar) (obj)).get(1));
            c1.a("month");
            c1.a(((Calendar) (obj)).get(2));
            c1.a("dayOfMonth");
            c1.a(((Calendar) (obj)).get(5));
            c1.a("hourOfDay");
            c1.a(((Calendar) (obj)).get(11));
            c1.a("minute");
            c1.a(((Calendar) (obj)).get(12));
            c1.a("second");
            c1.a(((Calendar) (obj)).get(13));
            c1.e();
            return;
        }
    }

    endar()
    {
    }
}
