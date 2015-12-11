// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class pa
    implements bdb
{

    private static long a;
    private final bmi b;
    private final oy c;
    private final qc d;
    private final pt e;
    private final bdc f;
    private final cub g;

    public pa(pb pb1)
    {
        b = (bmi)b.a(pb1.d);
        f = (bdc)b.a(pb1.h);
        g = (cub)b.a(pb1.f);
        c = new oy(pb1.a, pb1.b, pb1.c, pb1.d);
        bdo bdo1 = new bdo(pb1.c, pb1.j);
        d = new qc(b, bdo1);
        e = new pt(b, pb1.e, f, g, pb1.i, c, pb1.c, pb1.k);
    }

    public final bfx a(bxb bxb1)
    {
        b.b();
        b.a(bxb1);
        if (bxb1.k() == null)
        {
            return null;
        } else
        {
            return d.a(bxb1, a);
        }
    }

    public final buz a(bfz bfz, String s, bnb bnb, Map map)
    {
        long l = a;
        b.b();
        b.a(bfz);
        return e.a(bfz, s, l, bnb, map);
    }

    public final void a(buz buz1)
    {
        if (!buz1.d())
        {
            buz1 = f;
            long l = b.a();
            buz1.g = l;
            ((bdc) (buz1)).c.edit().putLong("last_ad_time", l).apply();
        }
    }

    public final boolean b(bxb bxb1)
    {
        b.a(bxb1);
        return bxb1.k() != null;
    }

    static 
    {
        a = TimeUnit.MINUTES.toMillis(15L);
    }
}
