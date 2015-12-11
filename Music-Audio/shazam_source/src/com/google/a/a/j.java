// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.a;

import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.a.a:
//            n, g

public final class j
{

    public final n a;
    public boolean b;
    public long c;
    private long d;

    public j()
    {
        this(n.b());
    }

    private j(n n1)
    {
        a = (n)g.a(n1, "ticker");
    }

    public final long a()
    {
        if (b)
        {
            return (a.a() - c) + d;
        } else
        {
            return d;
        }
    }

    public final String toString()
    {
        double d1;
        long l = a();
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[TimeUnit.values().length];
                try
                {
                    a[TimeUnit.NANOSECONDS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[TimeUnit.MICROSECONDS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[TimeUnit.MILLISECONDS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[TimeUnit.SECONDS.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[TimeUnit.MINUTES.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[TimeUnit.HOURS.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[TimeUnit.DAYS.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        TimeUnit timeunit;
        if (TimeUnit.DAYS.convert(l, TimeUnit.NANOSECONDS) > 0L)
        {
            timeunit = TimeUnit.DAYS;
        } else
        if (TimeUnit.HOURS.convert(l, TimeUnit.NANOSECONDS) > 0L)
        {
            timeunit = TimeUnit.HOURS;
        } else
        if (TimeUnit.MINUTES.convert(l, TimeUnit.NANOSECONDS) > 0L)
        {
            timeunit = TimeUnit.MINUTES;
        } else
        if (TimeUnit.SECONDS.convert(l, TimeUnit.NANOSECONDS) > 0L)
        {
            timeunit = TimeUnit.SECONDS;
        } else
        if (TimeUnit.MILLISECONDS.convert(l, TimeUnit.NANOSECONDS) > 0L)
        {
            timeunit = TimeUnit.MILLISECONDS;
        } else
        if (TimeUnit.MICROSECONDS.convert(l, TimeUnit.NANOSECONDS) > 0L)
        {
            timeunit = TimeUnit.MICROSECONDS;
        } else
        {
            timeunit = TimeUnit.NANOSECONDS;
        }
        d1 = (double)l / (double)TimeUnit.NANOSECONDS.convert(1L, timeunit);
        _cls1.a[timeunit.ordinal()];
        JVM INSTR tableswitch 1 7: default 92
    //                   1 222
    //                   2 246
    //                   3 252
    //                   4 258
    //                   5 264
    //                   6 270
    //                   7 276;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        throw new AssertionError();
_L2:
        String s = "ns";
_L10:
        return String.format("%.4g %s", new Object[] {
            Double.valueOf(d1), s
        });
_L3:
        s = "\u03BCs";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "ms";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "s";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "min";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "h";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "d";
        if (true) goto _L10; else goto _L9
_L9:
    }
}
