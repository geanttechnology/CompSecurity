// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.kahuna.sdk:
//            m

private class <init> extends Timer
{

    final m a;
    private long b;

    public long a()
    {
        return b;
    }

    public void schedule(TimerTask timertask, long l)
    {
        b = System.currentTimeMillis() + l;
        super.schedule(timertask, l);
    }

    private (m m1)
    {
        a = m1;
        super();
        b = -1L;
    }

    b(m m1, b b1)
    {
        this(m1);
    }
}
