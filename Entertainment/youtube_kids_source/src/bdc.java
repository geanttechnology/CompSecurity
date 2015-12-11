// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import java.util.concurrent.TimeUnit;

public class bdc
{

    public final bdi a;
    public final bkn b;
    public final SharedPreferences c;
    public final String d;
    public final bme e;
    public final ctw f;
    public long g;
    private final bmi h;

    public bdc(bdd bdd1)
    {
        a = bdd1.a;
        h = bdd1.b;
        Object obj = bdd1.c;
        b = bdd1.d;
        obj = bdd1.e;
        c = bdd1.f;
        d = bdd1.g;
        e = bdd1.h;
        f = bdd1.i;
        g = Math.min(h.a(), c.getLong("last_ad_time", 0L));
    }

    public int a()
    {
        long l;
        if (g > 0L)
        {
            if ((l = TimeUnit.MILLISECONDS.toSeconds(h.a() - g)) <= 0x7fffffffL && l > 0L)
            {
                return (int)l;
            }
        }
        return 0;
    }
}
