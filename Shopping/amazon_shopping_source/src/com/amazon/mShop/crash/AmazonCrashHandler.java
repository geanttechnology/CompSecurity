// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.crash;

import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;

public class AmazonCrashHandler
    implements Thread.UncaughtExceptionHandler
{

    private static AmazonCrashHandler sCrashHandler = null;
    private Thread.UncaughtExceptionHandler mSysUncaughtExceptionHandler;

    private AmazonCrashHandler(Thread.UncaughtExceptionHandler uncaughtexceptionhandler)
    {
        mSysUncaughtExceptionHandler = null;
        mSysUncaughtExceptionHandler = uncaughtexceptionhandler;
    }

    private String extractCrashInfo(Throwable throwable)
    {
        Object obj = null;
        if (throwable != null)
        {
            obj = new StringBuffer();
            ((StringBuffer) (obj)).append((new StringBuilder()).append(throwable.toString()).append("\n").toString());
            throwable = throwable.getStackTrace();
            int j = throwable.length;
            for (int i = 0; i < j; i++)
            {
                StackTraceElement stacktraceelement = throwable[i];
                ((StringBuffer) (obj)).append((new StringBuilder()).append(stacktraceelement.toString()).append("\n").toString());
            }

            obj = ((StringBuffer) (obj)).toString().substring(0, Math.min(((StringBuffer) (obj)).toString().length(), 255));
        }
        return ((String) (obj));
    }

    public static AmazonCrashHandler getInstance()
    {
        com/amazon/mShop/crash/AmazonCrashHandler;
        JVM INSTR monitorenter ;
        AmazonCrashHandler amazoncrashhandler;
        if (sCrashHandler == null)
        {
            sCrashHandler = new AmazonCrashHandler(Thread.getDefaultUncaughtExceptionHandler());
        }
        amazoncrashhandler = sCrashHandler;
        com/amazon/mShop/crash/AmazonCrashHandler;
        JVM INSTR monitorexit ;
        return amazoncrashhandler;
        Exception exception;
        exception;
        throw exception;
    }

    public void setupCrashHandler()
    {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        Exception exception;
        String s;
        DataStore datastore;
        try
        {
            s = extractCrashInfo(throwable);
            datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
        }
        catch (Throwable throwable1)
        {
            mSysUncaughtExceptionHandler.uncaughtException(thread, throwable);
            return;
        }
        finally
        {
            mSysUncaughtExceptionHandler.uncaughtException(thread, throwable);
        }
        if (datastore == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        if (!Util.isEmpty(s))
        {
            datastore.putString("applicationExitReason", s);
        }
        mSysUncaughtExceptionHandler.uncaughtException(thread, throwable);
        return;
        throw exception;
    }

}
