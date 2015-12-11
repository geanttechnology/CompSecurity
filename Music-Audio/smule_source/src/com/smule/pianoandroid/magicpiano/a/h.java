// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.a;

import com.smule.android.network.managers.e;
import com.smule.magicpiano.MagicPerformanceStats;
import com.smule.magicpiano.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.smule.pianoandroid.magicpiano.a:
//            k, i, j

public class h
{

    public static final String a = com/smule/pianoandroid/magicpiano/a/h.getName();
    List b;
    private int c;
    private int d;
    private double e;
    private int f;
    private k g;
    private j h;

    public h(MagicPerformanceStats magicperformancestats, j j1)
    {
        h = j1;
        c = magicperformancestats.scoringHitChords();
        d = magicperformancestats.totalScoringChords();
        e = magicperformancestats.songDuration;
        f = magicperformancestats.longestStreak;
        g = k.values()[magicperformancestats.difficulty];
        b = new ArrayList(magicperformancestats.starCounts.size());
        for (magicperformancestats = magicperformancestats.starCounts.iterator(); magicperformancestats.hasNext(); b.add(new i(Math.max(((a) (j1)).a - ((a) (j1)).b, 0), ((a) (j1)).c)))
        {
            j1 = (a)magicperformancestats.next();
        }

    }

    public static double a(int l, k k1)
    {
        return com.smule.pianoandroid.magicpiano.a.j.a().a(l, k1);
    }

    private long a(double d1)
    {
        return Math.round(Math.ceil(d1));
    }

    private double f()
    {
        return com.smule.pianoandroid.magicpiano.a.j.a().a(g);
    }

    private double g()
    {
        return com.smule.pianoandroid.magicpiano.a.j.a().a(f);
    }

    private double h()
    {
        if (d == 0)
        {
            return 0.0D;
        } else
        {
            return (double)c / (double)d;
        }
    }

    public long a()
    {
        return a(h.b() * h() * 100D * (e * h.c() + f()) * g());
    }

    public long b()
    {
        Iterator iterator = b.iterator();
        i l;
        long l1;
        long l2;
        for (l1 = 0L; iterator.hasNext(); l1 = h.b(l.b) * l2 + l1)
        {
            l = (i)iterator.next();
            l2 = l.a;
        }

        return l1;
    }

    public long c()
    {
        return a() + b() + d();
    }

    public long d()
    {
        float f1 = com.smule.android.network.managers.e.a().h();
        if (f1 > 0.0F)
        {
            return (long)Math.round((f1 - 1.0F) * (float)(a() + b()));
        } else
        {
            return 0L;
        }
    }

    public int e()
    {
        return f;
    }

}
