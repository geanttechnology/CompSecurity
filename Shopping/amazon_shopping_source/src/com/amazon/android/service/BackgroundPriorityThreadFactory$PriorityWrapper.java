// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.service;

import android.os.Process;
import com.amazon.logging.Logger;

// Referenced classes of package com.amazon.android.service:
//            BackgroundPriorityThreadFactory

protected static class name
    implements Runnable
{

    private static final Logger LOG = Logger.getLogger(com/amazon/android/service/BackgroundPriorityThreadFactory$PriorityWrapper);
    private final String name;
    private final int priority;
    private final Runnable runnable;

    public void run()
    {
        try
        {
            Process.setThreadPriority(priority);
            LOG.d((new StringBuilder()).append(name).append(": set thread priority to ").append(10).toString());
        }
        catch (SecurityException securityexception)
        {
            LOG.w((new StringBuilder()).append(name).append(": SecurityException caught, could not set thread priority to ").append(10).toString(), securityexception);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            LOG.w((new StringBuilder()).append(name).append(": IllegalArgumentException caught, could not set thread priority to ").append(10).toString(), illegalargumentexception);
        }
        runnable.run();
    }


    protected (Runnable runnable1, int i, String s)
    {
        runnable = runnable1;
        priority = i;
        name = s;
    }
}
