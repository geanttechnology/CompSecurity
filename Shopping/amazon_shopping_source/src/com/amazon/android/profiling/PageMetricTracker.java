// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.profiling;

import android.app.Activity;

// Referenced classes of package com.amazon.android.profiling:
//            PageMetrics

public final class PageMetricTracker
{

    private static Activity pageActivity;
    private static PageMetrics pageMetrics;

    protected PageMetricTracker()
    {
    }

    public static PageMetrics getAndResetMetrics()
    {
        com/amazon/android/profiling/PageMetricTracker;
        JVM INSTR monitorenter ;
        PageMetrics pagemetrics;
        pagemetrics = pageMetrics;
        pageMetrics = new PageMetrics();
        com/amazon/android/profiling/PageMetricTracker;
        JVM INSTR monitorexit ;
        return pagemetrics;
        Exception exception;
        exception;
        throw exception;
    }

    public static Activity getPageActivity()
    {
        return pageActivity;
    }

    public static void startPageMeasurement()
    {
        com/amazon/android/profiling/PageMetricTracker;
        JVM INSTR monitorenter ;
        getAndResetMetrics();
        pageMetrics.setPageStartTime(System.nanoTime());
        com/amazon/android/profiling/PageMetricTracker;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static 
    {
        startPageMeasurement();
    }
}
