// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import android.os.Looper;
import com.bumptech.glide.load.b;
import myobfuscated.f.m;

// Referenced classes of package com.bumptech.glide.load.engine:
//            ad, z

public final class y
    implements ad
{

    final boolean a;
    z b;
    b c;
    private int d;
    private boolean e;
    private final ad f;

    public y(ad ad1, boolean flag)
    {
        f = (ad)m.a(ad1, "Argument must not be null");
        a = flag;
    }

    public final Class a()
    {
        return f.a();
    }

    public final Object b()
    {
        return f.b();
    }

    public final int c()
    {
        return f.c();
    }

    public final void d()
    {
        if (d > 0)
        {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (e)
        {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        } else
        {
            e = true;
            f.d();
            return;
        }
    }

    public final void e()
    {
        if (e)
        {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper()))
        {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        } else
        {
            d = d + 1;
            return;
        }
    }

    public final void f()
    {
        if (d <= 0)
        {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper()))
        {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
        int i = d - 1;
        d = i;
        if (i == 0)
        {
            b.b(c, this);
        }
    }

    public final String toString()
    {
        return (new StringBuilder("EngineResource{isCacheable=")).append(a).append(", listener=").append(b).append(", key=").append(c).append(", acquired=").append(d).append(", isRecycled=").append(e).append(", resource=").append(f).append('}').toString();
    }
}
