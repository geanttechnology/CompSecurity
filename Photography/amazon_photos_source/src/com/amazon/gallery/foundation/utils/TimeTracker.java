// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils;

import android.os.SystemClock;
import com.amazon.gallery.foundation.utils.log.GLogger;

public class TimeTracker
{

    private static final String TAG = com/amazon/gallery/foundation/utils/TimeTracker.getName();
    private static long last;
    private static long start;

    public TimeTracker()
    {
    }

    public static void log(String s)
    {
        long l = SystemClock.uptimeMillis();
        if (l - start < 5000L)
        {
            GLogger.d(TAG, (new StringBuilder()).append(s).append(": %d : %d").toString(), new Object[] {
                Long.valueOf(l - last), Long.valueOf(l - start)
            });
            last = l;
        }
    }

    static 
    {
        start = SystemClock.uptimeMillis();
        last = start;
    }
}
