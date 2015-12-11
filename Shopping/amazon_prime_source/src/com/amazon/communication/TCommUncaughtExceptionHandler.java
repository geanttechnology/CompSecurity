// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import com.amazon.dp.logger.DPLogger;

public final class TCommUncaughtExceptionHandler
    implements Thread.UncaughtExceptionHandler
{

    private static final DPLogger log = new DPLogger("TComm.TCommUncaughtExceptionHandler");

    public TCommUncaughtExceptionHandler()
    {
    }

    private void dieIfFatalError(Throwable throwable)
    {
        if (throwable instanceof OutOfMemoryError)
        {
            System.exit(0);
        }
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        try
        {
            log.error("uncaughtException", "encountered an uncaught exception", new Object[] {
                "thread.getName", thread.getName(), throwable
            });
        }
        // Misplaced declaration of an exception variable
        catch (Thread thread)
        {
            dieIfFatalError(throwable);
            return;
        }
        finally
        {
            dieIfFatalError(throwable);
        }
        dieIfFatalError(throwable);
        return;
        throw thread;
    }

}
