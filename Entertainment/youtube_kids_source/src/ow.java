// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class ow
{

    private static final long e;
    private static final long f;
    public final bdb a;
    public final Executor b;
    public final bfo c;
    public long d;
    private final bmi g;
    private final bgm h;
    private final crh i;
    private final bmw j;
    private long k;

    public ow(bdb bdb1, bfo bfo, Executor executor, bmi bmi1, bgm bgm1, crh crh1, bmw bmw1)
    {
        this(bdb1, bfo, executor, bmi1, bgm1, crh1, bmw1, e);
    }

    private ow(bdb bdb1, bfo bfo, Executor executor, bmi bmi1, bgm bgm1, crh crh1, bmw bmw1, 
            long l)
    {
        a = (bdb)b.a(bdb1);
        c = bfo;
        b = (Executor)b.a(executor);
        g = (bmi)b.a(bmi1);
        h = (bgm)b.a(bgm1);
        i = (crh)b.a(crh1);
        j = (bmw)b.a(bmw1);
        d = l;
        k = f;
    }

    static bmi a(ow ow1)
    {
        return ow1.g;
    }

    static bdb b(ow ow1)
    {
        return ow1.a;
    }

    private buz b(buz buz1)
    {
        if (buz1 == null)
        {
            return null;
        } else
        {
            buz1 = buz1.a();
            buz1.i = j.a(12);
            return buz1.a();
        }
    }

    static bje c(ow ow1)
    {
        return null;
    }

    protected final bfm a(bfx bfx1, String s, bnb bnb, Map map)
    {
        Iterator iterator = bfx1.a.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_70;
            }
            bfx1 = (bfz)iterator.next();
        } while (((bfz) (bfx1)).a.c != bfr.a || ((bfz) (bfx1)).e == null || ((bfz) (bfx1)).e.isEmpty());
_L1:
        if (bfx1 == null)
        {
            return null;
        } else
        {
            return new bfm(bfx1, b(a.a(bfx1, s, bnb, map)));
        }
        bfx1 = null;
          goto _L1
    }

    public final void a(buz buz1)
    {
        a.a(buz1);
    }

    static 
    {
        e = TimeUnit.SECONDS.toMillis(15L);
        f = TimeUnit.MINUTES.toMillis(7L);
    }
}
