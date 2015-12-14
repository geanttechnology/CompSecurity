// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.effects.draw;

import android.os.Handler;
import myobfuscated.ay.b;

// Referenced classes of package com.socialin.android.photo.effects.draw:
//            a

final class b
    implements Runnable
{

    private long a;
    private boolean b;
    private a c;

    public final void run()
    {
        if (c.o == null)
        {
            return;
        }
        float f = Math.min(180L, System.currentTimeMillis() - a);
        if (b)
        {
            c.o.o = c.o.o + 5F;
        } else
        {
            c.o.o = c.o.o - 5F;
        }
        c.e();
        if (f < 180F)
        {
            c.p.post(this);
            return;
        }
        if (b)
        {
            c.o.o = b.m;
        } else
        {
            c.o.o = b.n;
        }
        c.e();
    }

    (a a1, long l, boolean flag)
    {
        c = a1;
        a = l;
        b = flag;
        super();
    }
}
