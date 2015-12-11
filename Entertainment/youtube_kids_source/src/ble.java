// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;

public class ble
{

    public final bqc a;
    public final SharedPreferences b;
    public final bmi c;

    public ble(SharedPreferences sharedpreferences, bqc bqc1, bmi bmi1)
    {
        b = (SharedPreferences)b.a(sharedpreferences);
        a = (bqc)b.a(bqc1);
        c = (bmi)b.a(bmi1);
    }

    public amv a(long l)
    {
        long l2 = bya.a(c.b(), l, b);
        long l1 = l2;
        if (c.b() > l2 - 50L)
        {
            l1 = c.b() + 10000L;
        }
        return (new amv()).a(bya.b).a(l1).b(l);
    }

    public bld a(amv amv1)
    {
        return b(amv1);
    }

    public String a()
    {
        return bya.b;
    }

    public bya b(amv amv1)
    {
        return new bya(b, c, a, amv1);
    }
}
