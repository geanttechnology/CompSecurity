// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.debug;

import android.os.Debug;
import android.os.Environment;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UncaughtExceptionHandler
    implements Thread.UncaughtExceptionHandler
{

    private static UncaughtExceptionHandler sCrashHandler = null;
    private Thread.UncaughtExceptionHandler mSysUncaughtExceptionHandler;

    private UncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtexceptionhandler)
    {
        mSysUncaughtExceptionHandler = null;
        mSysUncaughtExceptionHandler = uncaughtexceptionhandler;
    }

    public static UncaughtExceptionHandler getInstance()
    {
        com/amazon/mShop/debug/UncaughtExceptionHandler;
        JVM INSTR monitorenter ;
        UncaughtExceptionHandler uncaughtexceptionhandler;
        if (sCrashHandler == null)
        {
            sCrashHandler = new UncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
        }
        uncaughtexceptionhandler = sCrashHandler;
        com/amazon/mShop/debug/UncaughtExceptionHandler;
        JVM INSTR monitorexit ;
        return uncaughtexceptionhandler;
        Exception exception;
        exception;
        throw exception;
    }

    protected void dumpHprofFile(String s)
    {
        try
        {
            Debug.dumpHprofData(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    protected void logExceptionStackTrace(String s, Throwable throwable)
    {
        try
        {
            s = new PrintWriter(s, "UTF-8");
            throwable.printStackTrace(s);
            s.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        finally
        {
            throw s;
        }
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        Exception exception;
        try
        {
            String s1 = (new SimpleDateFormat("yy-MM-dd_HH:mm:ss")).format(new Date());
            String s = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/amazon_mShop_").append(s1).append("_stacktrace.txt").toString();
            s1 = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/amazon_mShop_").append(s1).append(".hprof").toString();
            logExceptionStackTrace(s, throwable);
            dumpHprofFile(s1);
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
        mSysUncaughtExceptionHandler.uncaughtException(thread, throwable);
        return;
        throw exception;
    }

}
