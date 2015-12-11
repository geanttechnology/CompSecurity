// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.os.Handler;
import com.mopub.common.m;

public abstract class v
    implements Runnable
{

    protected final Handler a;
    volatile boolean b;
    private volatile long c;

    v(Handler handler)
    {
        m.a(handler);
        a = handler;
    }

    public abstract void a();

    public final void a(long l)
    {
        boolean flag;
        if (l > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        m.a(flag, true, "intervalMillis must be greater than 0. Saw: %d", new Object[] {
            Long.valueOf(l)
        });
        c = l;
        if (!b)
        {
            b = true;
            a.post(this);
        }
    }

    public void run()
    {
        if (b)
        {
            a();
            a.postDelayed(this, c);
        }
    }
}
