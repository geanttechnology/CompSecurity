// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.debug;


// Referenced classes of package com.groupon.debug:
//            DebugQualityTools

static final class ler
    implements tionHandler
{

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        if (throwable instanceof OutOfMemoryError)
        {
            DebugQualityTools.dumpHprof("oom.hprof");
        }
        if (DebugQualityTools.access$000() != null)
        {
            DebugQualityTools.access$000().uncaughtException(thread, throwable);
        }
        return;
        Exception exception;
        exception;
        if (DebugQualityTools.access$000() != null)
        {
            DebugQualityTools.access$000().uncaughtException(thread, throwable);
        }
        throw exception;
    }

    ler()
    {
    }
}
