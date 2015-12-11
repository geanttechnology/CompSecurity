// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.os.SystemClock;

public abstract class hf
    implements Runnable
{

    private final long a = 300L;

    public hf()
    {
    }

    protected abstract boolean a();

    public void run()
    {
        long l = SystemClock.elapsedRealtime();
        long l1 = a;
        do
        {
            if (a() || (l + l1) - SystemClock.elapsedRealtime() <= 0L)
            {
                break;
            }
            try
            {
                Thread.sleep(0L);
                continue;
            }
            catch (InterruptedException interruptedexception) { }
            break;
        } while (true);
    }
}
