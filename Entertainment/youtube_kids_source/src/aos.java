// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.Choreographer;

public final class aos
    implements android.view.Choreographer.FrameCallback, aom
{

    private final boolean a = true;
    private final long b;
    private final long c;
    private Choreographer d;
    private long e;
    private long f;
    private long g;
    private long h;
    private boolean i;
    private long j;
    private long k;
    private int l;

    public aos(float f1, boolean flag)
    {
        b = (long)(1000000000D / (double)f1);
        c = (b * 80L) / 100L;
    }

    private boolean b(long l1, long l2)
    {
        long l3 = k;
        return Math.abs(l2 - j - (l1 - l3)) > 0x1312d00L;
    }

    public final long a(long l1, long l2)
    {
        long l6 = l1 * 1000L;
        if (!i) goto _L2; else goto _L1
_L1:
        if (l1 != f)
        {
            l = l + 1;
            g = h;
        }
        if (l < 6) goto _L4; else goto _L3
_L3:
        long l3;
        long l4;
        l3 = (l6 - k) / (long)l;
        l4 = g + l3;
        if (b(l4, l2))
        {
            i = false;
            l3 = l2;
            l4 = l6;
        } else
        {
            l3 = (j + l4) - k;
        }
_L6:
        if (!i)
        {
            k = l6;
            j = l2;
            l = 0;
            i = true;
        }
        f = l1;
        h = l4;
        if (e == 0L)
        {
            return l3;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (b(l6, l2))
        {
            i = false;
        }
_L2:
        l3 = l2;
        l4 = l6;
        if (true) goto _L6; else goto _L5
_L5:
        l1 = e;
        long l5 = b;
        l1 += ((l3 - l1) / l5) * l5;
        if (l3 <= l1)
        {
            l2 = l1 - l5;
        } else
        {
            l2 = l1;
            l1 = l5 + l1;
        }
        if (l1 - l3 >= l3 - l2)
        {
            l1 = l2;
        }
        return l1 - c;
    }

    public final void a()
    {
        i = false;
        if (a)
        {
            e = 0L;
            d = Choreographer.getInstance();
            d.postFrameCallback(this);
        }
    }

    public final void b()
    {
        if (a)
        {
            d.removeFrameCallback(this);
            d = null;
        }
    }

    public final void doFrame(long l1)
    {
        e = l1;
        d.postFrameCallbackDelayed(this, 500L);
    }
}
