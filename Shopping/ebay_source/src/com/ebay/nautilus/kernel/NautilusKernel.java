// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.util.Log;
import com.ebay.nautilus.kernel.content.EbayAppInfo;
import com.ebay.nautilus.kernel.content.EbayAppInfoImpl;

public class NautilusKernel
{
    private static final class CalledFromWrongThreadException extends RuntimeException
    {

        private static final long serialVersionUID = 1L;

        public CalledFromWrongThreadException(String s)
        {
            super(s);
        }
    }

    static final class QaMode
    {

        public final boolean isQaMode;

        public QaMode()
        {
            this(Log.isLoggable("fwUseQaServers", 3));
        }

        public QaMode(boolean flag)
        {
            isQaMode = flag;
        }
    }


    private static volatile EbayAppInfo appInfo;
    private static volatile QaMode qaMode;

    public NautilusKernel()
    {
    }

    private static void ensureAppInfo(Context context)
    {
        boolean flag = false;
        if (appInfo == null)
        {
            String s1 = context.getPackageName();
            String s;
            try
            {
                s = context.getPackageManager().getPackageInfo(s1, 0).versionName;
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                namenotfoundexception = "not versioned";
            }
            if ((context.getApplicationInfo().flags & 2) != 0)
            {
                flag = true;
            }
            appInfo = new EbayAppInfoImpl(s1, s, flag);
        }
    }

    public static void forceQaMode()
    {
        com/ebay/nautilus/kernel/NautilusKernel$QaMode;
        JVM INSTR monitorenter ;
        if (qaMode != null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        qaMode = new QaMode(true);
        com/ebay/nautilus/kernel/NautilusKernel$QaMode;
        JVM INSTR monitorexit ;
        return;
        throw new RuntimeException("Attempting to set QA mode after the app is without QA mode initialized!");
        Exception exception;
        exception;
        com/ebay/nautilus/kernel/NautilusKernel$QaMode;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static EbayAppInfo getAppInfo(Context context)
    {
        ensureAppInfo(context);
        return appInfo;
    }

    public static String getAppVersionBuildNumber(Context context)
    {
        ensureAppInfo(context);
        return appInfo.getAppVersionBuildNumber();
    }

    public static String getAppVersionName(Context context)
    {
        ensureAppInfo(context);
        return appInfo.getAppVersionName();
    }

    public static String getAppVersionWithoutBuildNumber(Context context)
    {
        ensureAppInfo(context);
        return appInfo.getAppVersionWithoutBuildNumber();
    }

    public static boolean isQaMode()
    {
        com/ebay/nautilus/kernel/NautilusKernel$QaMode;
        JVM INSTR monitorenter ;
        if (qaMode == null)
        {
            qaMode = new QaMode();
        }
        com/ebay/nautilus/kernel/NautilusKernel$QaMode;
        JVM INSTR monitorexit ;
        return qaMode.isQaMode;
        Exception exception;
        exception;
        com/ebay/nautilus/kernel/NautilusKernel$QaMode;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void verifyMain()
    {
        if (Looper.getMainLooper() != Looper.myLooper())
        {
            throw new CalledFromWrongThreadException("This method is only allowed on the main thread!");
        } else
        {
            return;
        }
    }

    public static void verifyNotMain()
    {
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            throw new CalledFromWrongThreadException("This method is not allowed on the main thread!");
        } else
        {
            return;
        }
    }
}
