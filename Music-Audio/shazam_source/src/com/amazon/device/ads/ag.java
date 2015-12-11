// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.Timer;
import java.util.TimerTask;

public final class ag
{

    private Timer a;

    ag()
    {
    }

    public final void a()
    {
        if (a != null)
        {
            a.cancel();
        }
    }

    public final void a(TimerTask timertask, long l)
    {
        a.schedule(timertask, l);
    }

    public final void b()
    {
        a();
        a = new Timer();
    }
}
