// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.debug;

import android.app.Application;
import android.os.Debug;
import android.os.Environment;
import android.os.StrictMode;
import java.io.File;
import roboguice.util.Ln;

public class DebugQualityTools
{

    private static Thread.UncaughtExceptionHandler originalUncaughtExceptionHandler;

    private DebugQualityTools()
    {
    }

    private static void configureOOMCrashLogging()
    {
        originalUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            public void uncaughtException(Thread thread, Throwable throwable)
            {
                if (throwable instanceof OutOfMemoryError)
                {
                    DebugQualityTools.dumpHprof("oom.hprof");
                }
                if (DebugQualityTools.originalUncaughtExceptionHandler != null)
                {
                    DebugQualityTools.originalUncaughtExceptionHandler.uncaughtException(thread, throwable);
                }
                return;
                Exception exception;
                exception;
                if (DebugQualityTools.originalUncaughtExceptionHandler != null)
                {
                    DebugQualityTools.originalUncaughtExceptionHandler.uncaughtException(thread, throwable);
                }
                throw exception;
            }

        });
    }

    private static void configureStrictMode()
    {
        StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).detectAll().permitDiskReads().penaltyLog().penaltyFlashScreen().penaltyDeath().build());
        StrictMode.setVmPolicy((new android.os.StrictMode.VmPolicy.Builder()).detectLeakedRegistrationObjects().penaltyLog().penaltyDeath().build());
    }

    public static void createInstance(Application application)
    {
        configureStrictMode();
        configureOOMCrashLogging();
    }

    public static void dumpHprof(String s)
    {
        try
        {
            Runtime.getRuntime().runFinalization();
            Runtime.getRuntime().gc();
            File file = new File(Environment.getExternalStorageDirectory(), s);
            Ln.e((new StringBuilder()).append("====== Dumping HPROF to: ").append(file).append("======").toString(), new Object[0]);
            Ln.e((new StringBuilder()).append("retrieve and convert using:\nadb pull /sdcard/").append(s).append(" /tmp/").append(s).append("\nhprof-conv /tmp/").append(s).append(" /tmp/").append(s).append(".converted.hprof\n").append("Then open the converted hprof file in Memory Analyzer").toString(), new Object[0]);
            Debug.dumpHprofData(file.getAbsolutePath());
            Ln.e((new StringBuilder()).append("heap was dumped to: /sdcard/").append(s).toString(), new Object[0]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Ln.e("dumping hprof failed", new Object[] {
                s
            });
        }
    }

    public static void verifyGC(Object obj)
    {
    }

}
