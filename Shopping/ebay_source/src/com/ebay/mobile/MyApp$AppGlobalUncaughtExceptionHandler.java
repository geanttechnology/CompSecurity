// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import com.ebay.nautilus.kernel.net.LogTrackError;
import com.ebay.nautilus.kernel.net.LogTrackManager;

// Referenced classes of package com.ebay.mobile:
//            MyApp

public static class 
    implements ndler
{

    private volatile boolean handled;
    private volatile Exception previous;

    public void attach()
    {
        previous = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        if (!handled)
        {
            handled = true;
            try
            {
                LogTrackManager.setCrashing();
                LogTrackManager.addLogErrorData(new LogTrackError("Application", "crash", null, null, "Application", "CrashError", throwable));
            }
            catch (Throwable throwable1)
            {
                throwable1.printStackTrace();
            }
            previous.uncaughtException(thread, throwable);
        }
    }

    public ()
    {
    }
}
