// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.os.SystemClock;

// Referenced classes of package com.millennialmedia.internal:
//            AdPlacementReporter

public static class 
{

    private long endTime;
    private long startTime;

    public long getElapsedTime()
    {
        if (endTime == 0L)
        {
            stop();
        }
        return endTime - startTime;
    }

    public void start()
    {
        startTime = SystemClock.elapsedRealtime();
        endTime = 0L;
    }

    public void stop()
    {
        endTime = SystemClock.elapsedRealtime();
    }

    public ()
    {
    }
}
